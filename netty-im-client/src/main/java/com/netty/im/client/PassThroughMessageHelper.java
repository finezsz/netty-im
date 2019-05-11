package com.netty.im.client;

import com.netty.im.client.utils.AuthUtils;
import com.netty.im.client.utils.NettyClientUtils;
import com.netty.im.core.message.Message;
import com.netty.im.core.message.Message.Builder;
import com.netty.im.core.message.type.MessageType;
import com.netty.im.core.util.StringUtils;

import io.netty.channel.ChannelFuture;

/**
 * 透传消息发送类
 * 
 * @author pc
 *
 */
public enum PassThroughMessageHelper {

	HEART_BEAT(MessageType.HEART_BEAT.getType());

	PassThroughMessageHelper(int messageType) {
		this.messageType = messageType;
	}

	private int messageType;

	public static void main(String[] args) throws Exception {
	}

	public void sendHeartBeatMessage() throws Exception {
		String id = StringUtils.uniqueStr();
		Builder builder = Message.newBuilder();
		builder.setId(id).setMessageType(messageType);
		builder.setSender(AuthUtils.getSender()).setToken(AuthUtils.getToken());

		Message message = builder.build();

		ChannelFuture channelFuture = NettyClientUtils.sendMessage(message);
	}

}
