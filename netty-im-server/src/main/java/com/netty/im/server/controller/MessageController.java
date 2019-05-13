package com.netty.im.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netty.im.core.message.Message;
import com.netty.im.core.util.ChannelGroups; 

import io.netty.channel.Channel; 

/**
 * 消息API,提供消息的基本操作
 * @author myim
 *
 */
@RestController
@RequestMapping("/message")
public class MessageController {
	
	/**
	 * 推送消息给所有客户端
	 * @param content	消息内容
	 * @return
	 */
	@GetMapping("/push")
	public Object pushAllMessage(String content) {
		Message message =Message.newBuilder().setContent(content).build(); 
		ChannelGroups.broadcast(message);
		return "success";
	}
	
	/**
	 * 推送消息给指定客户端
	 * @param clientId  客户端ID
	 * @param content	消息内容
	 * @return
	 */
	@GetMapping("/push/{clientId}")
	public Object pushAllMessage(@PathVariable("clientId")String clientId, String content) {
		Channel channel =ChannelGroups.getChannelByUserId(clientId);
		Message message =Message.newBuilder().setContent(content).build(); 
		channel.writeAndFlush(message);
		return "success";
	}
	
}
