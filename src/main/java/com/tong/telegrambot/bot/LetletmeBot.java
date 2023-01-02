package com.tong.telegrambot.bot;

import com.tong.telegrambot.service.ILetletmeBotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Create by tong on 2023/1/2
 */
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LetletmeBot extends TelegramLongPollingBot {

    private final ILetletmeBotService letletmeBotService;

    @Override
    public String getBotUsername() {
        return "letletme";
    }

    @Override
    public String getBotToken() {
        return "5454272773:AAF1d7fbZXX3qe3PNwPcutEDyKckaxK8mOg";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        if (StringUtils.isBlank(text)) {
            return;
        }
        SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
        if (text.startsWith("/price_change")) {
            String result = this.letletmeBotService.priceChange();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(result);
        }
        if (text.startsWith("/ddl")) {
            String result = this.letletmeBotService.ddl();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(result);
        }
        if (StringUtils.isEmpty(message.getText())) {
            return;
        }
        try {
            this.execute(message); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
