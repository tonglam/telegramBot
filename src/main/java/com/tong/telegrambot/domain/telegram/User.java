package com.tong.telegrambot.domain.telegram;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * This object represents a Telegram user or bot.
 * <p>
 * Created by tong on 2022/08/22
 */
@Data
@Accessors(chain = true)
public class User {

    private Integer Id; // Unique identifier for this user or bot. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier.
    private Boolean isBot = Boolean.TRUE; // True, if this user is a bot
    private String firstName; // User's or bot's first name
    private String lastName; // Optional. User's or bot's last name
    private String username; // Optional. User's or bot's username
    private String languageCode; // Optional. IETF language tag of the user's language
    private Boolean isPremium = Boolean.TRUE; // Optional. True, if this user is a Telegram Premium user
    private Boolean addedToAttachmentMenu = Boolean.TRUE; // Optional. True, if this user added the bot to the attachment menu
    private Boolean canJoinGroups; // Optional. True, if the bot can be invited to groups. Returned only in getMe.
    private Boolean canReadAllGroupMessages; // Optional. True, if privacy mode is disabled for the bot. Returned only in getMe.
    private Boolean supportsInlineQueries; // Optional. True, if the bot supports inline queries. Returned only in getMe.

}
