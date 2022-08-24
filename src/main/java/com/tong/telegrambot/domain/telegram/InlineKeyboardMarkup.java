package com.tong.telegrambot.domain.telegram;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * This object represents an inline keyboard that appears right next to the message it belongs to.
 * <p>
 * Created by tong on 2022/08/23
 */
@Data
@Accessors(chain = true)
public class InlineKeyboardMarkup {

    private List<InlineKeyboardButton> inlineKeyboard; // Array of button rows, each represented by an Array of InlineKeyboardButton objects

}
