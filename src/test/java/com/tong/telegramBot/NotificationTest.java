package com.tong.telegramBot;

import com.tong.telegramBot.service.INotificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Create by tong on 2023/1/5
 */
public class NotificationTest extends TelegramBotApplicationTests{

    @Autowired
    private INotificationService notificationService;

    @Test
    void playerValueNotification(){
        this.notificationService.playerValueNotification();
    }

}
