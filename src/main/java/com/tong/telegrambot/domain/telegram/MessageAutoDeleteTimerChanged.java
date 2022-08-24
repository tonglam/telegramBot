package com.tong.telegrambot.domain.telegram;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by tong on 2022/08/23
 */
@Data
@Accessors(chain = true)
public class MessageAutoDeleteTimerChanged {

    private Integer messageAutoDeleteTime; // New auto-delete time for messages in the chat; in seconds

}
