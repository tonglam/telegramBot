package com.tong.telegrambot.domain.telegram;

import com.tong.telegrambot.domain.telegram.games.Game;
import com.tong.telegrambot.domain.telegram.payments.Invoice;
import com.tong.telegrambot.domain.telegram.payments.SuccessfulPayment;
import com.tong.telegrambot.domain.telegram.telegramPassport.PassportData;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * This object represents a message.
 * <p>
 * Created by tong on 2022/08/22
 */
@Data
@Accessors(chain = true)
public class Message {

    private String messageId; // Unique message identifier inside this chat
    private User from; // Optional. Sender of the message; empty for messages sent to channels. For backward compatibility, the field contains a fake sender user in non-channel chats, if the message was sent on behalf of a chat.
    private Chat senderChat; // Optional. Sender of the message, sent on behalf of a chat. For example, the channel itself for channel posts, the supergroup itself for messages from anonymous group administrators, the linked channel for messages automatically forwarded to the discussion group. For backward compatibility, the field from contains a fake sender user in non-channel chats, if the message was sent on behalf of a chat.
    private Integer date; // Date the message was sent in Unix time
    private Chat chat; // Conversation the message belongs to
    private User forwardFrom; // Optional. For forwarded messages, sender of the original message
    private Chat forwardFromChat; // Optional. For messages forwarded from channels or from anonymous administrators, information about the original sender chat
    private Integer forwardFromMessageId; // Optional. For messages forwarded from channels, identifier of the original message in the channel
    private String forward_signature; // Optional. For forwarded messages that were originally sent in channels or by an anonymous chat administrator, signature of the message sender if present
    private String forwardSenderName; // Optional. Sender's name for messages forwarded from users who disallow adding a link to their account in forwarded messages
    private Integer forwardDate; // Optional. For forwarded messages, date the original message was sent in Unix time
    private Boolean isAutomaticForward = Boolean.TRUE; // Optional. True, if the message is a channel post that was automatically forwarded to the connected discussion group
    private Message replyToMessage; // Optional. For replies, the original message. Note that the Message object in this field will not contain further reply_to_message fields even if it itself is a reply.
    private User viaBot; // Optional. Bot through which the message was sent
    private Integer editDate; // Optional. Date the message was last edited in Unix time
    private Boolean hasProtectedContent = Boolean.TRUE; // Optional. True, if the message can't be forwarded
    private String mediaGroupId; // Optional. The unique identifier of a media message group this message belongs to
    private String authorSignature; // Optional. Signature of the post author for messages in channels, or the custom title of an anonymous group administrator
    private String text; // Optional. For text messages, the actual UTF-8 text of the message
    private List<MessageEntity> entities; // Optional. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
    private Animation animation; // Optional. Message is an animation, information about the animation. For backward compatibility, when this field is set, the document field will also be set
    private Audio audio; // Optional. Message is an audio file, information about the file
    private Document document; // Optional. Message is a general file, information about the file
    private PhotoSize photo; // Optional. Message is a photo, available sizes of the photo
    private Sticker sticker; // Optional. Message is a sticker, information about the sticker
    private Video video; // Optional. Message is a video, information about the video
    private VideoNote videoNote; // Optional. Message is a video note, information about the video message
    private Voice voice; // Optional. Message is a voice message, information about the file
    private String caption; // Optional. Caption for the animation, audio, document, photo, video or voice
    private List<MessageEntity> captionEntities; // Optional. For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption
    private Contact contact; // Optional. Message is a shared contact, information about the contact
    private Dice dice; // Optional. Message is a dice with random value
    private Game game; // Optional. Message is a game, information about the game. More about games »
    private Poll poll; // Optional. Message is a native poll, information about the poll
    private Venue venue; // Optional. Message is a venue, information about the venue. For backward compatibility, when this field is set, the location field will also be set
    private Location location; // Optional. Message is a shared location, information about the location
    private List<User> newChatMembers; // Optional. New members that were added to the group or supergroup and information about them (the bot itself may be one of these members)
    private User leftChatMember; // Optional. A member was removed from the group, information about them (this member may be the bot itself)
    private String newChatTitle; // Optional. A chat title was changed to this value
    private List<PhotoSize> newChatPhoto; // Optional. A chat photo was change to this value
    private Boolean deleteChatPhoto = Boolean.TRUE; // Optional. Service message: the chat photo was deleted
    private Boolean groupChatCreated = Boolean.TRUE; // Optional. Service message: the group has been created
    private Boolean supergroupChatCreated = Boolean.TRUE; // Optional. Service message: the supergroup has been created. This field can't be received in a message coming through updates, because bot can't be a member of a supergroup when it is created. It can only be found in reply_to_message if someone replies to a very first message in a directly created supergroup.
    private Boolean channelChatCreated = Boolean.TRUE; // Optional. Service message: the channel has been created. This field can't be received in a message coming through updates, because bot can't be a member of a channel when it is created. It can only be found in reply_to_message if someone replies to a very first message in a channel.
    private MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged; // Optional. Service message: auto-delete timer settings changed in the chat
    private Integer migrateToChatId; // Optional. The group has been migrated to a supergroup with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
    private Integer migrateFromChatId; // Optional. The supergroup has been migrated from a group with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
    private Message pinnedMessage; // Optional. Specified message was pinned. Note that the Message object in this field will not contain further reply_to_message fields even if it is itself a reply.
    private Invoice invoice; // Optional. Message is an invoice for a payment, information about the invoice. More about payments »
    private SuccessfulPayment successfulPayment; // Optional. Message is a service message about a successful payment, information about the payment. More about payments »
    private String connectedWebsite; // Optional. The domain name of the website on which the user has logged in. More about Telegram Login »
    private PassportData passportData; // Optional. Telegram Passport data
    private ProximityAlertTriggered proximityAlertTriggered; // Optional. Service message. A user in the chat triggered another user's proximity alert while sharing Live Location.
    private VideoChatScheduled videoChatScheduled; // Optional. Service message: video chat scheduled
    private VideoChatStarted videoChatStarted; // Optional. Service message: video chat started
    private VideoChatEnded videoChatEnded; // Optional. Service message: video chat ended
    private VideoChatParticipantsInvited videoChatParticipantsInvited; // Optional. Service message: new participants invited to a video chat
    private WebAppData webAppData; // Optional. Service message: data sent by a Web App
    private InlineKeyboardMarkup replyMarkup; // Optional. Inline keyboard attached to the message. login_url buttons are represented as ordinary url buttons.

}
