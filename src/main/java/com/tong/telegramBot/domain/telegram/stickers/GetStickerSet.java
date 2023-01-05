package com.tong.telegramBot.domain.telegram.stickers;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * Use this method to get a sticker set. On success, a StickerSet object is returned.
 * <p>
 * Created by tong on 2022/08/25
 */
@Data
@Accessors(chain = true)
public class GetStickerSet {

    @NotNull
    private String name; // Name of the sticker set

}
