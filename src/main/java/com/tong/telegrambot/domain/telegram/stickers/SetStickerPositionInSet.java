package com.tong.telegrambot.domain.telegram.stickers;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * Use this method to move a sticker in a set created by the bot to a specific position. Returns True on success.
 * <p>
 * Created by tong on 2022/08/25
 */
@Data
@Accessors(chain = true)
public class SetStickerPositionInSet {

    @NotNull
    private String sticker; // File identifier of the sticker
    @NotNull
    private Integer position; // New sticker position in the set, zero-based

}
