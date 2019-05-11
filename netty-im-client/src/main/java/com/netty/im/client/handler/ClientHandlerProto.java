package com.netty.im.client.handler;

import com.netty.im.client.PassThroughMessageHelper;
import com.netty.im.client.utils.NettyClientUtils;
import com.netty.im.core.message.Message;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ClientHandlerProto extends ChannelInboundHandlerAdapter {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		Message message = null;
		try {
			message = (Message) msg;
		} catch (Exception e) { // 转换对象异常，说明非法通信z，关闭连接
			ctx.close();
			logger.error(e.getMessage(),e);
		}
		logger.info("client:" + message.toString());

		// ChannelInboundHandlerAdapter需要手动释放消息？
		ReferenceCountUtil.release(message);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		logger.error(cause.getMessage(),cause);
		ctx.close();
	}

	/**
	 * 连接建立触发
	 * @param ctx
	 * @throws Exception
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("和服务端建立连接成功" + ctx.channel());
		PassThroughMessageHelper.HEART_BEAT.sendHeartBeatMessage();//连接一建立就发送一个心跳供服务端初始化连接通道信息
		super.channelActive(ctx);
	}

	/**
	 * 断线触发
	 * @param ctx
	 * @throws Exception
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// 使用过程中断线重连
		Channel channel = ctx.channel();
		logger.error("连接服务端ip {}掉线了",channel.remoteAddress());
		final EventLoop eventLoop = channel.eventLoop();
		eventLoop.schedule(new Runnable() {
			@Override
			public void run() {
				NettyClientUtils.connect();
			}
		}, 1L, TimeUnit.SECONDS);
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
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		super.userEventTriggered(ctx, evt);
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent event = (IdleStateEvent) evt;
			if (event.state().equals(IdleState.READER_IDLE)) {
				logger.info("长期没收到服务器推送数据");
			} else if (event.state().equals(IdleState.WRITER_IDLE)) {
				logger.info("长期未向服务器发送数据");
				// 发送心跳包
				PassThroughMessageHelper.HEART_BEAT.sendHeartBeatMessage();
			} else if (event.state().equals(IdleState.ALL_IDLE)) {
				logger.info("长期没和服务端通信");
			}
		}
	}
}
