package com.tong.telegramBot.service.impl;

import com.google.common.collect.Lists;
import com.tong.telegramBot.api.ILetletmeBotApi;
import com.tong.telegramBot.bot.LetletmeBot;
import com.tong.telegramBot.constant.Constant;
import com.tong.telegramBot.domain.bot.common.UserInfoData;
import com.tong.telegramBot.service.ILetletmeBotCommandService;
import com.tong.telegramBot.service.INotificationService;
import com.tong.telegramBot.utils.CommonUtils;
import com.tong.telegramBot.utils.RedisUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

/**
 * Create by tong on 2023/1/5
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NotificationServiceImpl implements INotificationService {

    private final InterfaceServiceImpl interfaceService;
    private final ILetletmeBotCommandService letletmeBotCommandService;

    private LetletmeBot bot;
    private final List<String> notificationUsers = Lists.newArrayList("tonglam14", "让让我");

    @PostConstruct
    private void init() {
        bot = new LetletmeBot(letletmeBotCommandService);
    }

    @Override
    public void textNotification(String text, List<String> userList) {
        userList.forEach(user -> {
            UserInfoData userInfo = RedisUtils.readHashValue(Constant.BOT_USER_INFO_KEY, user);
            if (userInfo == null) {
                return;
            }
            this.bot.sendTextNotification(text, userInfo);
        });
    }

    @Override
    public void imageNotification(String url, String caption, List<String> userList) {
        userList.forEach(user -> {
            UserInfoData userInfo = RedisUtils.readHashValue(Constant.BOT_USER_INFO_KEY, user);
            if (userInfo == null) {
                return;
            }
            this.bot.sendImageNotification(url, caption, userInfo);
        });
    }

    @Override
    public void playerValueNotification() {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern(Constant.SHORTDAY));
        String key = Constant.BOT_NOTIFICATION_KEY;
        // sent
        Optional<String> result = this.interfaceService.qryPlayerValueByDate(date);
        result.ifPresent(s -> notificationUsers.forEach(user -> {
            String hashKey = StringUtils.joinWith("::", "player_value", user, date);
            // check
            if (RedisUtils.readHashValue(key, hashKey) != null) {
                return;
            }
            String text = CommonUtils.initPlayerValueData(s);
            if (StringUtils.isEmpty(text)) {
                return;
            }
            this.textNotification(text, Lists.newArrayList(user));
            RedisUtils.setHashValue(key, hashKey, s);
        }));
    }

}
