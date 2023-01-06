package com.tong.telegramBot.service;

import com.tong.telegramBot.domain.bot.common.NoticeData;
import com.tong.telegramBot.domain.bot.letletme.HermesNoticeData;

import java.util.List;

/**
 * Create by tong on 2023/1/2
 */
public interface ILetletmeBotCommandService {

    String priceChange();

    String ddl();

    int live();

    List<NoticeData> hermesAll();

}
