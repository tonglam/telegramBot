package com.tong.telegrambot.domain.telegram;

import com.tong.telegrambot.domain.telegram.games.CallbackGame;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * This object represents one button of an inline keyboard. You must use exactly one of the optional fields.
 * <p>
 * Created by tong on 2022/08/23
 */
@Data
@Accessors(chain = true)
public class InlineKeyboardButton {

    private String text; // Label text on the button
    private String url; // Optional. HTTP or tg:// URL to be opened when the button is pressed. Links tg://user?id=<user_id> can be used to mention a user by their ID without using a username, if this is allowed by their privacy settings.
    private String callbackData; // Optional. Data to be sent in a callback query to the bot when button is pressed, 1-64 bytes
    private WebAppInfo webApp; // Optional. Description of the Web App that will be launched when the user presses the button. The Web App will be able to send an arbitrary message on behalf of the user using the method answerWebAppQuery. Available only in private chats between a user and the bot.
    private LoginUrl loginUrl; // Optional. An HTTPS URL used to automatically authorize the user. Can be used as a replacement for the Telegram Login Widget.
    private String switchInlineQuery; // Optional. If set, pressing the button will prompt the user to select one of their chats, open that chat and insert the bot's username and the specified inline query in the input field. May be empty, in which case just the bot's username will be inserted.
    private String switchInlineQueryCurrentChat; // Optional. If set, pressing the button will insert the bot's username and the specified inline query in the current chat's input field. May be empty, in which case only the bot's username will be inserted. This offers a quick way for the user to open your bot in inline mode in the same chat - good for selecting something from multiple options.
    private CallbackGame callbackGame; // Optional. Description of the game that will be launched when the user presses the button. NOTE: This type of button must always be the first button in the first row.
    private Boolean pay = Boolean.TRUE; // Optional. Specify True, to send a Pay button. NOTE: This type of button must always be the first button in the first row and can only be used in invoice messages.

}
