package com.netty.im.client.core;

import com.netty.im.client.handler.SslChannelInitializer;
import com.netty.im.client.listener.ConnectionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.TrustManagerFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;

public class ImConnection {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private Channel channel;
	private String host;
	private int port;

	public ImConnection(String host, int port) {
		try {
			this.host = host;
			this.port = port;
			connect();
			// 连接成功发一个连接数据

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

	public Channel getChannel() {
		return channel;
	}

	public void connect() throws Exception {
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		Bootstrap bootstrap = new Bootstrap();
		bootstrap.group(workerGroup);
		bootstrap.channel(NioSocketChannel.class);
		bootstrap.handler(new LoggingHandler(LogLevel.INFO));
		bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
		bootstrap.option(ChannelOption.TCP_NODELAY, true);
		bootstrap.option(ChannelOption.SO_REUSEADDR, true);
		bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);

		try {
			KeyStore keyStore = KeyStore.getInstance("JKS");
			keyStore.load(new FileInputStream("E:\\workspace\\myim\\netty-im\\ssl\\cChat.jks"), "bejoy100%@myim".toCharArray());
			TrustManagerFactory tf = TrustManagerFactory.getInstance("SunX509");
			tf.init(keyStore);
			SslContext sslContext = SslContextBuilder.forClient().trustManager(tf).build();
			bootstrap.handler(new SslChannelInitializer(sslContext));
//			bootstrap.handler(new PlainChannelInitializer());
		 
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}

		ChannelFuture connectFuture = bootstrap.connect(host, port).addListener(new ConnectionListener()).sync();
		channel = connectFuture.channel();
	}

}
