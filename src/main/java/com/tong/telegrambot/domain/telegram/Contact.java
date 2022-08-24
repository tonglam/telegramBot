package com.tong.telegrambot.domain.telegram;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * This object represents a phone contact.
 *
 * Created by tong on 2022/08/22
 */
@Data
@Accessors(chain = true)
public class Contact {

    private String phoneNumber; // Contact's phone number
    private String firstName; // Contact's first name
    private String lastName; // Optional. Contact's last name
    private Integer userId; // Optional. Contact's user identifier in Telegram. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier.
    private String vcard; // Optional. Additional data about the contact in the form of a vCard

}
