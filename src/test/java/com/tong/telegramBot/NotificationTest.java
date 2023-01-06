package com.tong.telegramBot;

import com.google.common.collect.Lists;
import com.tong.telegramBot.constant.Constant;
import com.tong.telegramBot.service.INotificationService;
import com.tong.telegramBot.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Create by tong on 2023/1/5
 */
public class NotificationTest extends TelegramBotApplicationTests {

    @Autowired
    private INotificationService notificationService;

    @ParameterizedTest
    @CsvSource({"TIME FOR PIZZA, 轮子"})
    void textNotification(String text, String user) {
        this.notificationService.textNotification(text, Lists.newArrayList(user));
    }

    @ParameterizedTest
    @CsvSource({"https://assets.hermes.com/is/image/hermesproduct/082831CAAJ_worn_1, tonglam14"})
    void imageNotification(String url, String user) {
        Map<Object, Object> map = RedisUtils.getHashByKey(Constant.HERMES_KEY);
        String caption = "Cabas H en Biais 40 bag (ass), https://www.hermes.com/uk/en/product/cabas-h-en-biais-40-bag-H082831CAAJ/";
        this.notificationService.imageNotification(url, caption, Lists.newArrayList(user));
    }

    @Test
    void playerValueNotification() {
        this.notificationService.playerValueNotification();
    }

}
