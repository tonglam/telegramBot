package com.tong.telegrambot.domain.telegram;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * This object represents one size of a photo or a file / sticker thumbnail.
 * <p>
 * Created by tong on 2022/08/22
 */
@Data
@Accessors(chain = true)
public class PhotoSize {

    private String fileId; // Identifier for this file, which can be used to download or reuse the file
    private String fileUniqueId; // Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
    private Integer width; // Photo width
    private Integer height; // Photo height
    private Integer fileSize; // Optional. File size in bytes

}
