package com.tong.telegramBot.service;

/**
 * Create by tong on 2023/1/5
 */
public interface INotificationService {

    void notification(String text, String user);

    void playerValueNotification();

}
