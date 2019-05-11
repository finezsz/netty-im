package com.netty.im.client.handler;

import java.util.concurrent.TimeUnit;

import com.netty.im.core.message.Message;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;

public class PlainChannelInitializer extends ChannelInitializer<SocketChannel> {
	@Override
	public void initChannel(SocketChannel ch) throws Exception {
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
		// 实体类传输数据，protobuf序列化

		ch.pipeline().addLast("ping", new IdleStateHandler(180, 180, 60 * 10, TimeUnit.SECONDS));
		ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
		ch.pipeline().addLast("decoder", new ProtobufDecoder(Message.getDefaultInstance()));
		ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
		ch.pipeline().addLast("encoder", new ProtobufEncoder());
		ch.pipeline().addLast(new ClientHandlerProto());
		
		/*
		 * ch.pipeline().addLast("decoder", new KryoDecoder());
		 * ch.pipeline().addLast("encoder", new KryoEncoder());
		 */
		// ch.pipeline().addLast(new ClientPoHandler());

		// 字符串传输数据
		/*
		 * ch.pipeline().addLast("decoder", new StringDecoder());
		 * ch.pipeline().addLast("encoder", new StringEncoder());
		 * ch.pipeline().addLast(new ClientStringHandler());
		 */
	}
}