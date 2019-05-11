package com.netty.im.client.listener;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netty.im.client.utils.NettyClientUtils;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoop;
 
public class ConnectionListener implements ChannelFutureListener {
	 
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public void operationComplete(ChannelFuture channelFuture) throws Exception {
		if (!channelFuture.isSuccess()) {
			final EventLoop loop = channelFuture.channel().eventLoop();
			loop.schedule(new Runnable() {
				@Override
				public void run() {
					logger.error("连接到服务端失败，开始重连操作...");
					NettyClientUtils.connect();
				}
			}, 1L, TimeUnit.SECONDS);
		} else {
			logger.info("连接到服务端成功...");
		}
	}
}
