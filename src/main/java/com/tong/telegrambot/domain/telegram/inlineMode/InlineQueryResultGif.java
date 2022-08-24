package com.tong.telegrambot.domain.telegram.inlineMode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tong.telegrambot.domain.telegram.InlineKeyboardMarkup;
import com.tong.telegrambot.domain.telegram.MessageEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the user with optional caption. Alternatively, you can use input_message_content to send a message with the specified content instead of the animation.
 * <p>
 * Created by tong on 2022/08/24
 */
@Getter
@Setter
@Accessors(chain = true)
public class InlineQueryResultGif extends InlineQueryResult {

    private String type; // Type of the result, must be gif
    private String id; // Unique identifier for this result, 1-64 bytes
    @JsonProperty("gif_url")
    private String gifUrl; // A valid URL for the GIF file. File size must not exceed 1MB
    @JsonProperty("gif_width")
    private Integer gifWidth; // Optional. Width of the GIF
    @JsonProperty("gif_height")
    private Integer gifHeight; // Optional. Height of the GIF
    @JsonProperty("gif_duration")
    private Integer gifDuration; // Optional. Duration of the GIF in seconds
    @JsonProperty("thumb_url")
    private String thumbUrl; // URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
    @JsonProperty("thumb_mime_type")
    private String thumbMimeType; // Optional. MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”. Defaults to “image/jpeg”
    private String title; // Optional. Title for the result
    private String caption; // Optional. Caption of the GIF file to be sent, 0-1024 characters after entities parsing
    @JsonProperty("parse_mode")
    private String parseMode; // Optional. Mode for parsing entities in the caption. See formatting options for more details.
    @JsonProperty("caption_entities")
    private List<MessageEntity> captionEntities; // Optional. List of special entities that appear in the caption, which can be specified instead of parse_mode
    @JsonProperty("reply_markup")
    private InlineKeyboardMarkup replyMarkup; // Optional. Inline keyboard attached to the message
    @JsonProperty("input_message_content")
    private InputMessageContent inputMessageContent; // Optional. Content of the message to be sent instead of the GIF animation

}