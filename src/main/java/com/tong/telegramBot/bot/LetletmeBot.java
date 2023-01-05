package com.tong.telegramBot.bot;

import com.google.common.base.CaseFormat;
import com.tong.telegramBot.constant.Constant;
import com.tong.telegramBot.domain.bot.letletme.UserInfoData;
import com.tong.telegramBot.utils.CommonUtils;
import com.tong.telegramBot.utils.RedisUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Create by tong on 2023/1/2
 */
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LetletmeBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return Constant.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return Constant.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        this.saveUserInfo(update);
        String text = update.getMessage().getText();
        if (StringUtils.isBlank(text)) {
            return;
        }
        boolean isCommand = false;
        if (text.contains("/")) {
            isCommand = true;
        }
        SendMessage message = new SendMessage();
        if (isCommand) {
            String result = this.processCommand(text);
            if (result == null) {
                return;
            }
            message.setText(result);
        }
        message.setChatId(update.getMessage().getChatId());
        if (StringUtils.isEmpty(message.getText())) {
            return;
        }
        try {
            this.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    // save telegram user_info
    private void saveUserInfo(Update update) {
        Chat chat = update.getMessage().getChat();
        if (chat == null) {
            return;
        }
        UserInfoData userInfoData = new UserInfoData()
                .setChatId(chat.getId())
                .setType(chat.getType());
        if (StringUtils.equals("supergroup", chat.getType()) || StringUtils.equals("group", chat.getType())) {
            userInfoData
                    .setTitle(chat.getTitle())
                    .setHashKey(chat.getTitle());
        } else if (StringUtils.equals("private", chat.getType())) {
            userInfoData
                    .setFirstName(chat.getFirstName())
                    .setLastName(chat.getLastName())
                    .setUserName(chat.getUserName())
                    .setHashKey(chat.getUserName());
        }
        RedisUtils.setHashValue(Constant.BOT_USER_INFO_KEY, userInfoData.getHashKey(), userInfoData);
    }

    // process bot command
    private String processCommand(String text) {
        if (text.contains("@")) {
            text = StringUtils.substringBefore(text, "@");
        }
        String result = "";
        // parse command
        String methodName = "";
        String args = "";
        if (!text.contains(" ")) {
            methodName = StringUtils.substringAfter(text, "/");
            args = null;
        } else {
            methodName = StringUtils.substringBetween(text, "/", " ");
            args = StringUtils.substringAfter(text, " ");
        }
        if (methodName.contains("_")) {
            methodName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, methodName);
        }
        result = CommonUtils.invokeBotCommandService(methodName, args);
        return result;
    }

    public void sendNotification(String text, UserInfoData userInfo) {
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setChatId(userInfo.getChatId());
        try {
            this.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
