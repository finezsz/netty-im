package com.netty.im.server.handler;

import javax.net.ssl.SSLEngine;

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

public class SslChannelInitializer extends ChannelInitializer<Channel> {
	private final SslContext context;

	public SslChannelInitializer(SslContext context) {
		this.context = context;
	}

	@Override
	protected void initChannel(Channel ch) throws Exception {
		SSLEngine engine = context.newEngine(ch.alloc());
		engine.setUseClientMode(false);
		ch.pipeline().addFirst("ssl", new SslHandler(engine));
		ChannelPipeline pipeline = ch.pipeline();
		
		pipeline.addLast(new ProtobufVarint32FrameDecoder());
		pipeline.addLast("decoder", new ProtobufDecoder(Message.getDefaultInstance()));
		pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
		pipeline.addLast("encoder", new ProtobufEncoder());
		pipeline.addLast(new ServerHandlerProto());
		 
	}
}