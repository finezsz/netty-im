package com.netty.im.client.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netty.im.client.Constants;
import com.netty.im.client.utils.NettyClientUtils;
import com.netty.im.core.message.Message;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

/**
 * 发送消息监听器父类
 * 
 * @author pc
 *
 */
public abstract class SendMessageListener implements ChannelFutureListener {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	public int retryCount = 0;
	public Message message;

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public void operationComplete(ChannelFuture future) throws Exception {// 后发的可能先回调，不保证顺序
		if (future.isSuccess()) {// 成功说明已发送到服务器端NioEventLoopGroup线程处理，不代表应用层成功处理
			logger.info(message + "发送成功");
			doSuccess(message);
		} else if (retryCount++ < Constants.SEND_MESSAGE_RETRY_COUNT) {// 失败重发
			logger.info(message + "失败重发第" + retryCount + "次");
			NettyClientUtils.sendMessage(message, this);
		} else {
			// 做发送失败处理
			logger.error(message + "发送失败");
			doFailed(message);
		}
	}

	/**
	 * 发送失败处理
	 * @param message
	 */
	abstract void doFailed(Message message);;

	/**
	 * 发送成功处理
	 * @param message
	 */
	abstract void doSuccess(Message message);

}