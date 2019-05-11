package com.netty.im.server.handler;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netty.im.core.message.Message;
import com.netty.im.server.utils.ChannelUtils;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;
import io.netty.util.ReferenceCountUtil;

/**
 * 
 * 
 * @author pc
 *
 */
public class ServerHandlerProto extends ChannelInboundHandlerAdapter {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	public static final AttributeKey<Object> USER_ID = AttributeKey.valueOf("userId");

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		Message message = null;
		try {
			message = (Message) msg;
		} catch (Exception e) {
			ctx.close();
			logger.error(e.getMessage(),e);
		}
		logger.info("服务端收到消息：" + message);
		Channel channel = ctx.channel();

		if (!isValid(message)) {
			logger.error("非法请求" + channel);
			ctx.close();
			return;
		}

		message.toBuilder().setTimeMillis(System.currentTimeMillis());

		Object userId = channel.attr(USER_ID).get();
		if (userId==null||StringUtils.isBlank(userId.toString())) {
			long sender = message.getSender();
			channel.attr(USER_ID).set(sender);
			ChannelUtils.addChannel(sender, channel);

			ChannelUtils.addChannelHost(userId);
		}

		// ping
		// if (message.getMessageType() == MessageType.HEART_BEAT.getType()) {
		// ctx.writeAndFlush(message);
		// }
		ReferenceCountUtil.release(message);
	}

	/**
	 * 身份认证
	 *
	 * @param message
	 * @return
	 */
	private boolean isValid(Message message) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 建立连接触发
	 * @param ctx
	 * @throws Exception
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("和客户端建立连接成功" + ctx.channel());
		super.channelActive(ctx);
	}

	/**
	 * 掉线触发
	 * @param ctx
	 * @throws Exception
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		Channel channel = ctx.channel();

		Object userId = channel.attr(USER_ID).get();
		logger.error("用户{}掉线了,ip {},chanell {}",userId,channel.remoteAddress(),channel);
		ChannelUtils.removeChannel(userId);
		super.channelInactive(ctx);
	}


	// 通道建立事件
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		super.handlerAdded(ctx);
	}


	// 通道被移除事件
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		super.handlerRemoved(ctx);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		logger.error(cause.getMessage(),cause);
		ctx.close();
	}
}
