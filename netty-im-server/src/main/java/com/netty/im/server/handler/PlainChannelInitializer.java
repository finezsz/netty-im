package com.netty.im.server.handler;

import com.netty.im.core.message.Message;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

public class PlainChannelInitializer extends ChannelInitializer<SocketChannel> {
	@Override
	public void initChannel(SocketChannel socketChannel) throws Exception {
		// ch.pipeline().addLast("frameDecoder", new
		// LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
		// ch.pipeline().addLast("frameEncoder", new LengthFieldPrepender(4));
		// 实体类传输数据，jdk序列化
		/*
		 * ch.pipeline().addLast("decoder", new MessageDecoder());
		 * ch.pipeline().addLast("encoder", new MessageEncoder());
		 */
		// 使用框架自带的对象编解码器
		/*
		 * ch.pipeline().addLast( new ObjectDecoder( ClassResolvers.cacheDisabled(
		 * this.getClass().getClassLoader() ) ) ); ch.pipeline().addLast(new
		 * ObjectEncoder());
		 */
		/*
		 * ch.pipeline().addLast("decoder", new KryoDecoder());
		 * ch.pipeline().addLast("encoder", new KryoEncoder());
		 */

		// 实体类传输数据，protobuf序列化
		socketChannel.pipeline().addLast(new ProtobufVarint32FrameDecoder());
		socketChannel.pipeline().addLast("decoder", new ProtobufDecoder(Message.getDefaultInstance()));
		socketChannel.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
		socketChannel.pipeline().addLast("encoder", new ProtobufEncoder());
		socketChannel.pipeline().addLast(new ServerHandlerProto());

		// ch.pipeline().addLast(new ServerPoHandler());
		// 字符串传输数据
		/*
		 * ch.pipeline().addLast("decoder", new StringDecoder());
		 * ch.pipeline().addLast("encoder", new StringEncoder());
		 * ch.pipeline().addLast(new ServerStringHandler());
		 */
	}
}