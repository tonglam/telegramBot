package com.tong.telegrambot;

import com.tong.telegrambot.bot.LetletmeBot;
import com.tong.telegrambot.service.ILetletmeBotService;
import com.tong.telegrambot.service.impl.LetletmeBotServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class TelegramBotApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(TelegramBotApplication.class, args);
		try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
			ILetletmeBotService letletmeBotService = app.getBean(ILetletmeBotService.class);
			botsApi.registerBot(new LetletmeBot(letletmeBotService));
		} catch (TelegramApiException e) {
			throw new RuntimeException(e);
		}
	}

}
