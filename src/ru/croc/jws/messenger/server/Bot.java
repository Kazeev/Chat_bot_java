package ru.croc.jws.messenger.server;

import ru.croc.jws.messenger.common.Message;
import ru.croc.jws.messenger.common.User;

public interface Bot {

	/**
	 * Returns user for the current bot.
	 * @return user representing this bot
	 */
	User getUser();

	/**
	 * Callback for a message with a direct mention of this bot name.
	 * @param message message to the bot
	 * @param messageRepository chat messages repository
	 */
	void onMessage(Message message, MessageRepository messageRepository);
}
