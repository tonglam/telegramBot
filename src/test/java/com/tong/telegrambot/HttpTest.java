package com.tong.telegrambot;

import com.tong.telegrambot.constant.Constant;
import com.tong.telegrambot.utils.HttpUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

/**
 * Create by tong on 2023/1/2
 */
public class HttpTest extends TelegramBotApplicationTests {

    @Test
    void get() throws IOException {
        Optional<String> result = HttpUtils.httpGet(String.format(Constant.FPL_PLAYER_VALUE_BY_DATE, "20230102"));
        System.out.println(1);
    }

}
