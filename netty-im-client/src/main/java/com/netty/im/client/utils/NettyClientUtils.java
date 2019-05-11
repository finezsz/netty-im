package com.netty.im.client.utils;

import com.netty.im.client.core.ImConnection;
import com.netty.im.core.message.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

/**
 * im发送客户端
 * 
 * @author pc
 *
 */
public class NettyClientUtils {
	protected static final Logger logger = LoggerFactory.getLogger(NettyClientUtils.class);
	public static final String HOST = "127.0.0.1";
	public static int PORT = 2222;
	public static ImConnection imConnection = new ImConnection(HOST, PORT);

	public static void main(String[] args) throws Exception {
	}

	/**
	 * 发送消息并回调处理结果
	 * @param message
	 * @param channelFutureListener
	 * @return
	 * @throws Exception
	 */
	public static ChannelFuture sendMessage(Message message, ChannelFutureListener channelFutureListener)
			throws Exception {
		ChannelFuture channelFuture = imConnection.getChannel().writeAndFlush(message);
		channelFuture.addListener(channelFutureListener);
		return channelFuture;
	}
	
	/**
	 * 发送消息但不回调处理结果
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public static ChannelFuture sendMessage(Message message)
			throws Exception {
		ChannelFuture channelFuture = imConnection.getChannel().writeAndFlush(message); 
		return channelFuture;
	}

	/**
	 * 建立连接
	 * 
	 * @throws Exception
	 */
	public static void connect() {
		try {
			imConnection.connect();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

}
