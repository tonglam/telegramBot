package com.tong.telegrambot;

import com.tong.telegrambot.service.ILetletmeBotService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Create by tong on 2023/1/2
 */
public class LetletmeBotTest extends TelegramBotApplicationTests {

    @Autowired
    private ILetletmeBotService letletmeBotService;

    @Test
    void priceChange() {
        String a = this.letletmeBotService.priceChange();
        System.out.println(1);
    }

    @Test
    void ddl(){
        String a = this.letletmeBotService.ddl();
        System.out.println(1);
    }

}
