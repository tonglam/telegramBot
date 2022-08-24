package com.tong.telegrambot.domain.telegram.availableTypes;

import com.tong.telegrambot.domain.telegram.User;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Represents a chat member that isn't currently a member of the chat, but may join it themselves.
 * <p>
 * Created by tong on 2022/08/24
 */
@Getter
@Setter
@Accessors
public class ChatMemberLeft extends ChatMember {

    private String status; // The member's status in the chat, always “left”
    private User user; // Information about the user

}