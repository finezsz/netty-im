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
		} catch (Exception e) { // 鐎电钖勬潪顒佸床瀵倸鐖剁拠瀛樻鐎广垺鍩涚粩顖氬絺闁線娼▔鏇熸殶閹诡噯绱濋崗鎶芥４鏉╃偞甯�
			ctx.close();
			logger.error(e.getMessage(),e);
		}
		logger.info("服务端收到消息：" + message);
		Channel channel = ctx.channel();
		// 闁村瓨娼�
		if (!isValid(message)) {// 闂堢偞纭剁拠閿嬬湴閼奉亜濮╅崗鎶芥４閿涘矂妲诲銏′紦閹板繑鏁鹃崙姹囷拷鍌氼吂閹撮顏В蹇旑偧閸氼垰濮╃憰浣藉殰閸斻劍顥呭ù瀣秼閸撳秶鏁ら幋閿嬫Ц閸氾妇娅ラ崗銉礉濞岋紕娅ラ崗銉ㄧ殶閸掓壆娅ラ崗銉ф櫕闂堬拷
			logger.error("非法请求" + channel);
			ctx.close();
			return;
		}
		// 鐠佸墽鐤嗗☉鍫熶紖閺冨爼妫�
		message.toBuilder().setTimeMillis(System.currentTimeMillis());

		Object userId = channel.attr(USER_ID).get();
		if (userId==null||StringUtils.isBlank(userId.toString())) {
			long sender = message.getSender();
			channel.attr(USER_ID).set(sender);
			ChannelUtils.addChannel(sender, channel);
			// 娣囨繂鐡ㄩ悽銊﹀煕channel閸︺劌鎽㈤崣鐗堟簚閸ｏ拷
			ChannelUtils.addChannelHost(userId);
		}

		// ping
		// if (message.getMessageType() == MessageType.HEART_BEAT.getType()) {
		// ctx.writeAndFlush(message);
		// }
		ReferenceCountUtil.release(message);
	}

	/**
	 * 閺勵垰鎯侀崥鍫熺《鐠囬攱鐪�
	 * 
	 * @param message
	 * @return
	 */
	private boolean isValid(Message message) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("和客户端建立连接成功" + ctx.channel());
		super.channelActive(ctx);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// channel婢惰鲸鏅ユ径鍕倞,鐎广垺鍩涚粩顖欑瑓缁炬寧鍨ㄩ懓鍛繁閸掑爼锟斤拷閸戣櫣鐡戞禒璁崇秿閹懎鍠岄柈鍊熜曢崣鎴ｇ箹娑擃亝鏌熷▔锟�
		Channel channel = ctx.channel();
		Object userId = channel.attr(USER_ID).get();
		logger.error("用户:" + userId + "," + channel + "掉线了");
		ChannelUtils.removeChannel(userId);// 閹哄鍤庨崚鐘绘珟閺堫剙婀存穱婵嗙摠閻ㄥ垻hannel
		super.channelInactive(ctx);
	}

	// 闁岸浜惧铏圭彌娴滃娆�
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		super.handlerAdded(ctx);
	}

	// 闁岸浜剧悮顐ば╅梽銈勭皑娴狅拷
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		super.handlerRemoved(ctx);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
