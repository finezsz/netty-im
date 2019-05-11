package com.netty.im.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.netty.im.server.core.NettyServerUtils;

/**
 * IM服务启动入口
 * 
 * @author pc
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = { "com.netty.im,com.mycode" })
public class ImServerApp {
	public static void main(String[] args) {
		int port = 2222;
		new Thread(() -> {
			NettyServerUtils.startMessageServer(port);
		}).start();
		SpringApplication.run(ImServerApp.class, args);
	}
}
