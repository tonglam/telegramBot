package com.tong.telegrambot.constant;

/**
 * Created by tong on 2022/08/22
 */
public class Constant {

    // bot-letletme
    private static final String TOKEN = "bot5454272773:AAF1d7fbZXX3qe3PNwPcutEDyKckaxK8mOg";
    private static final String PREFIX = "https://api.telegram.org/" + TOKEN + "/";

    // date_format
    public static final String DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE = "yyyy-MM-dd";
    public static final String SHORTDAY = "yyyyMMdd";

    // fpl
    private static final String FPL_PREFIX = "https://letletme.top/api/";
    public static final String FPL_PLAYER_VALUE_BY_DATE = FPL_PREFIX + "stat/qryPlayerValueByDate?date=%s";
    public static final String FPL_CURRENT_EVENT_AND_NEXT_UTC_DEADLINE = FPL_PREFIX + "common/qryCurrentEventAndNextUtcDeadline";

}
