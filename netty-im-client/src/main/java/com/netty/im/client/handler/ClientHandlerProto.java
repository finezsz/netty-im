package com.netty.im.client.handler;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netty.im.client.PassThroughMessageHelper;
import com.netty.im.client.utils.NettyClientUtils;
import com.netty.im.core.message.Message;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;

public class ClientHandlerProto extends ChannelInboundHandlerAdapter {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		Message message = null;
		try {
			message = (Message) msg;
		} catch (Exception e) { // 转换对象异常，说明非法通信，关闭连接
			ctx.close();
			e.printStackTrace();
		}
		logger.info("client:" + message.toString());

		// ChannelInboundHandlerAdapter需要手动释放消息？
		ReferenceCountUtil.release(message);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("和服务端建立连接成功" + ctx.channel());
		PassThroughMessageHelper.HEART_BEAT.sendHeartBeatMessage();//连接一建立就发送一个心跳供服务端初始化连接通道信息
		super.channelActive(ctx);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.error("掉线了...");
		// 使用过程中断线重连
		final EventLoop eventLoop = ctx.channel().eventLoop();
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
