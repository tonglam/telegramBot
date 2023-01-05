package com.tong.telegramBot;

import com.tong.telegramBot.service.INotificationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Create by tong on 2023/1/5
 */
public class NotificationTest extends TelegramBotApplicationTests {

    @Autowired
    private INotificationService notificationService;

    @ParameterizedTest
    @CsvSource({"TIME FOR PIZZA, 轮子"})
    void notification(String text, String user) {
        this.notificationService.notification(text, user);
    }

    @Test
    void playerValueNotification() {
        this.notificationService.playerValueNotification();
    }

}
