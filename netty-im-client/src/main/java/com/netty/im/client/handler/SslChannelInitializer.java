package com.netty.im.client.handler;

import com.netty.im.core.message.Message;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.timeout.IdleStateHandler;

import javax.net.ssl.SSLEngine;
import java.util.concurrent.TimeUnit;

public class SslChannelInitializer extends ChannelInitializer<Channel> {
	private final SslContext context;

	public SslChannelInitializer(SslContext context) {
		this.context = context;
	}

	@Override
	protected void initChannel(Channel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		SSLEngine engine = context.newEngine(ch.alloc());
		engine.setUseClientMode(true);
		pipeline.addFirst("ssl", new SslHandler(engine));

		
		pipeline.addLast("ping", new IdleStateHandler(180, 180, 60 * 10, TimeUnit.SECONDS));
		pipeline.addLast(new ProtobufVarint32FrameDecoder());
		pipeline.addLast("decoder", new ProtobufDecoder(Message.getDefaultInstance()));
		pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
		pipeline.addLast("encoder", new ProtobufEncoder());
		pipeline.addLast(new ClientHandlerProto());
		
	}
}