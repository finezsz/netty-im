package com.netty.im.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netty.im.client.listener.BroadcastMessageListener;
import com.netty.im.client.listener.GroupMessageListener;
import com.netty.im.client.listener.SendMessageListener;
import com.netty.im.client.listener.SingleMessageListener;
import com.netty.im.client.utils.AuthUtils;
import com.netty.im.client.utils.NettyClientUtils;
import com.netty.im.core.message.Message;
import com.netty.im.core.message.Message.Builder;
import com.netty.im.core.message.type.ContentType;
import com.netty.im.core.message.type.MessageType;
import com.netty.im.core.util.StringUtils;

import io.netty.channel.ChannelFuture;

/**
 * 用户消息发送类
 * 
 * @author pc
 *
 */
public enum UserMessageHelper {

	SINGLE_MESSAGE(MessageType.SINGLE_MESSAGE.getType()), GROUP_MESSAGE(
			MessageType.GROUP_MESSAGE.getType()), BROADCAST_MESSAGE(MessageType.BROADCAST_MESSAGE.getType());

	UserMessageHelper(int messageType) {
		this.messageType = messageType;
	}

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private int messageType;

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			String content = "发送的内容" + i;
			UserMessageHelper.SINGLE_MESSAGE.sendTextMessage(content, 1L);
		}
	}

	/**
	 * 发送单聊消息
	 * 
	 * @param content
	 * @param receiver
	 * @throws Exception
	 */
	public void sendTextMessage(String content, long receiver) throws Exception {
		String id = StringUtils.uniqueStr();
		Builder builder = Message.newBuilder();
		builder.setId(id).setContent(content).setMessageType(messageType);
		builder.setContentType(ContentType.TEXT.getType()).setReceiver(receiver);
		builder.setSender(AuthUtils.getSender()).setToken(AuthUtils.getToken());

		Message message = builder.build();
		SendMessageListener sendMessageListener = getSendMessageListener(message);
		ChannelFuture channelFuture = NettyClientUtils.sendMessage(message, sendMessageListener);
	}

	
	/**
	 * 根据不同消息类型获取消息监听器
	 * @param message
	 * @return
	 */
	private SendMessageListener getSendMessageListener(Message message) {
		SendMessageListener sendMessageListener = null;
		if (message.getMessageType() == MessageType.SINGLE_MESSAGE.getType()) {
			sendMessageListener = new SingleMessageListener();
		}
		if (message.getMessageType() == MessageType.GROUP_MESSAGE.getType()) {
			sendMessageListener = new GroupMessageListener();
		}
		if (message.getMessageType() == MessageType.BROADCAST_MESSAGE.getType()) {
			sendMessageListener = new BroadcastMessageListener();
		}
		sendMessageListener.setMessage(message);
		return sendMessageListener;
	}
 

}
