package com.netty.im.server.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.mycode.common.redis.CommonRedisAdapter;
import com.mycode.common.redis.PersistRedisClusterClient;
import com.mycode.common.utils.NetWorkUtils;

import io.netty.channel.Channel;

public class ChannelUtils {
	private static final Map<Object, Channel> USER_CHANNEL = new ConcurrentHashMap<Object, Channel>();
	private static final PersistRedisClusterClient CHANNEL_HOST = new PersistRedisClusterClient(CommonRedisAdapter.CHANNEL_HOST);

	/**
	 * 根据userId获取channel
	 * 
	 * @param userId
	 * @return
	 */
	public static Channel getChannel(Object userId) {
		return USER_CHANNEL.get(userId);
	}

	/**
	 * 根据userId删除channel，返回刚删除的channel，如果没有则返回null
	 * 
	 * @param userId
	 * @return
	 */
	public static Channel removeChannel(Object userId) {
		return USER_CHANNEL.remove(userId);
	}

	/**
	 * 添加userId的channel
	 * 
	 * @param userId
	 * @param channel
	 * @return
	 */
	public static Channel addChannel(Object userId, Channel channel) {
		return USER_CHANNEL.put(userId, channel);
	}

	/**
	 * 全局保存用户channel在哪台机器
	 * @param userId
	 * @throws Exception
	 */
	public static void addChannelHost(Object userId) throws Exception {
		CHANNEL_HOST.set(userId, NetWorkUtils.getIntranetIp());
	}
}
