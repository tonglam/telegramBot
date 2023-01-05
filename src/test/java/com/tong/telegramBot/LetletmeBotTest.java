package com.tong.telegramBot;

import com.tong.telegramBot.bot.LetletmeBot;
import com.tong.telegramBot.constant.Constant;
import com.tong.telegramBot.domain.bot.letletme.UserInfoData;
import com.tong.telegramBot.service.ILetletmeBotCommandService;
import com.tong.telegramBot.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Create by tong on 2023/1/2
 */
public class LetletmeBotTest extends TelegramBotApplicationTests {

    @Autowired
    private ILetletmeBotCommandService letletmeBotService;

    @Test
    void priceChange() {
        String a = this.letletmeBotService.priceChange();
        System.out.println(1);
    }

    @Test
    void ddl() {
        String a = this.letletmeBotService.ddl();
        System.out.println(1);
    }

    @ParameterizedTest
    @CsvSource({"test notification, tonglam14"})
    void test(String text, String username) {
        UserInfoData userInfoData = RedisUtils.readHashValue(Constant.BOT_USER_INFO_KEY, username);
        LetletmeBot bot = new LetletmeBot();
        bot.sendNotification(text, userInfoData);
    }

}
