package com.netty.im.server.core;

import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;

import com.netty.im.server.handler.SslChannelInitializer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;

public class NettyServerUtils {

	/**
	 * 开启一个监听端口
	 * 
	 * @param port
	 */
	public static void startMessageServer(int port) {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap.option(ChannelOption.SO_BACKLOG, 128);
		bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
		bootstrap.childOption(ChannelOption.TCP_NODELAY, true);
		bootstrap.handler(new LoggingHandler(LogLevel.INFO));
		bootstrap.group(bossGroup, workerGroup);
		bootstrap.channel(NioServerSocketChannel.class);

		try {
			KeyStore keyStore = KeyStore.getInstance("JKS");
			keyStore.load(new FileInputStream("E:\\workspace\\myim\\netty-im\\ssl\\sChat.jks"),
					"bejoy100%@myim".toCharArray());
			KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
			keyManagerFactory.init(keyStore, "bejoy100%@myim".toCharArray());
			SslContext sslContext = SslContextBuilder.forServer(keyManagerFactory).build();
			bootstrap.childHandler(new SslChannelInitializer(sslContext));
//			bootstrap.childHandler(new PlainChannelInitializer());

			ChannelFuture bindFuture = bootstrap.bind(port).sync();
			bindFuture.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

}
