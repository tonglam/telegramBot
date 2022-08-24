package com.tong.telegrambot.domain.telegram;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * This object represents a sticker set.
 * <p>
 * Created by tong on 2022/08/22
 */
@Data
@Accessors(chain = true)
public class StickerSet {

    private String name; // Sticker set name
    private String title; // Sticker set title
    private String stickerType; // Type of stickers in the set, currently one of “regular”, “mask”, “custom_emoji”
    private Boolean isAnimated = Boolean.TRUE; // True, if the sticker set contains animated stickers
    private Boolean isVideo = Boolean.TRUE; //True, if the sticker set contains video stickers
    private List<Sticker> stickers; // List of all set stickers
    private PhotoSize thumb; // Optional. Sticker set thumbnail in the .WEBP, .TGS, or .WEBM format

}
