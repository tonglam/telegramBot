package com.tong.telegrambot.domain.telegram.gettingUpdates;

import com.tong.telegrambot.domain.telegram.Message;
import com.tong.telegrambot.domain.telegram.Poll;
import com.tong.telegrambot.domain.telegram.PollAnswer;
import com.tong.telegrambot.domain.telegram.availableTypes.CallbackQuery;
import com.tong.telegrambot.domain.telegram.availableTypes.ChatJoinRequest;
import com.tong.telegrambot.domain.telegram.availableTypes.ChatMemberUpdated;
import com.tong.telegrambot.domain.telegram.inlineMode.ChosenInlineResult;
import com.tong.telegrambot.domain.telegram.inlineMode.InlineQuery;
import com.tong.telegrambot.domain.telegram.payments.PreCheckoutQuery;
import com.tong.telegrambot.domain.telegram.payments.ShippingQuery;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * This object represents an incoming update.
 * At most one of the optional parameters can be present in any given update.
 * <p>
 * Created by tong on 2022/08/24
 */
@Data
@Accessors(chain = true)
public class Update {

    private Integer updateId; // The update's unique identifier. Update identifiers start from a certain positive number and increase sequentially. This ID becomes especially handy if you're using webhooks, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially.
    private Message message; // Optional. New incoming message of any kind - text, photo, sticker, etc.
    private Message editedMessage; // Optional. New version of a message that is known to the bot and was edited
    private Message channelPost; // Optional. New incoming channel post of any kind - text, photo, sticker, etc.
    private Message editedChannelPost; // Optional. New version of a channel post that is known to the bot and was edited
    private InlineQuery inlineQuery; // Optional. New incoming inline query
    private ChosenInlineResult chosenInlineResult; // Optional. The result of an inline query that was chosen by a user and sent to their chat partner. Please see our documentation on the feedback collecting for details on how to enable these updates for your bot.
    private CallbackQuery callbackQuery; // Optional. New incoming callback query
    private ShippingQuery shippingQuery; // Optional. New incoming shipping query. Only for invoices with flexible price
    private PreCheckoutQuery preCheckoutQuery; // Optional. New incoming pre-checkout query. Contains full information about checkout
    private Poll poll; // Optional. New poll state. Bots receive only updates about stopped polls and polls, which are sent by the bot
    private PollAnswer pollAnswer; // Optional. A user changed their answer in a non-anonymous poll. Bots receive new votes only in polls that were sent by the bot itself.
    private ChatMemberUpdated myChatMember; // Optional. The bot's chat member status was updated in a chat. For private chats, this update is received only when the bot is blocked or unblocked by the user.
    private ChatMemberUpdated chatMember; // Optional. A chat member's status was updated in a chat. The bot must be an administrator in the chat and must explicitly specify “chat_member” in the list of allowed_updates to receive these updates.
    private ChatJoinRequest chatJoinRequest; // Optional. A request to join the chat has been sent. The bot must have the can_invite_users administrator right in the chat to receive these updates.

}
