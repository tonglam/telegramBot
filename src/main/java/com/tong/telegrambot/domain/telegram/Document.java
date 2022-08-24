package com.tong.telegrambot.domain.telegram;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by tong on 2022/08/22
 */
@Data
@Accessors(chain = true)
public class Document {

    private String fileId; // Identifier for this file, which can be used to download or reuse the file
    private String fileUniqueId; // Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
    private PhotoSize thumb; // Optional. Document thumbnail as defined by sender
    private String fileName; // Optional. Original filename as defined by sender
    private String mimeType; // Optional. MIME type of the file as defined by sender
    private Integer fileSize; // Optional. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.

}
