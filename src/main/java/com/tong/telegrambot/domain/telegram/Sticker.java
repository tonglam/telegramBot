package com.tong.telegrambot.domain.telegram;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * This object represents a sticker.
 * <p>
 * Created by tong on 2022/08/22
 */
@Data
@Accessors(chain = true)
public class Sticker {

    private String fileId; // Identifier for this file, which can be used to download or reuse the file
    private String fileUniqueId; // Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
    private String type; // Type of the sticker, currently one of “regular”, “mask”, “custom_emoji”. The type of the sticker is independent from its format, which is determined by the fields is_animated and is_video.
    private Integer width; // Sticker width
    private Integer height; // Sticker height
    private Boolean isAnimated = Boolean.TRUE; // True, if the sticker is animated
    private Boolean isVideo = Boolean.TRUE; // True, if the sticker is a video sticker
    private PhotoSize thumb; // Optional. Sticker thumbnail in the .WEBP or .JPG format
    private String emoji; // Optional. Emoji associated with the sticker
    private String setName; // Optional. Name of the sticker set to which the sticker belongs
    private File premiumAnimation; // Optional. For premium regular stickers, premium animation for the sticker
    private MaskPosition maskPosition; // Optional. For mask stickers, the position where the mask should be placed
    private String customEmojiId; // Optional. For custom emoji stickers, unique identifier of the custom emoji
    private Integer fileSize; // Optional. File size in bytes

}
