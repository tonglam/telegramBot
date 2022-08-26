package com.tong.telegrambot.domain.telegram.updatingmessages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tong.telegrambot.domain.telegram.InlineKeyboardMarkup;
import com.tong.telegrambot.domain.telegram.MessageEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Use this method to edit only the reply markup of messages. On success, if the edited message is not an inline message, the edited Message is returned, otherwise True is required.
 * <p>
 * Created by tong on 2022/08/25
 */
@Data
@Accessors(chain = true)
public class EditMessageReplyMarkup {

    @JsonProperty("chat_id")
    private String chatId; // Required if inline_message_id is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername)
    @JsonProperty("message_id")
    private Integer messageId; // Required if inline_message_id is not specified. Identifier of the message to edit
    @JsonProperty("inline_message_id")
    private String inlineMessageId; // Required if chat_id and message_id are not specified. Identifier of the inline message
    @JsonProperty("reply_markup")
    private InlineKeyboardMarkup replyMarkup; // A JSON-serialized object for an inline keyboard.

}
