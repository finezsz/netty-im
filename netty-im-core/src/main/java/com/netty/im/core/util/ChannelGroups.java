package com.netty.im.core.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelGroupFuture;
import io.netty.channel.group.ChannelMatcher;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ChannelGroups {

	private static final ChannelGroup CHANNEL_GROUP = new DefaultChannelGroup("ChannelGroups",
			GlobalEventExecutor.INSTANCE);

	/**
	 * 改成redis存
	 */
	private static final Map<Object, ChannelId> USER_CHANNELIDS = new ConcurrentHashMap<Object, ChannelId>();

	public static void putChannel(Object userId, Channel channel) {
		putChannelId(userId, channel.id());
		add(channel);
	}

	public static void putChannelId(Object userId, ChannelId id) {
		USER_CHANNELIDS.put(userId, id);
	}

	public static void romveChannelId(Object userId) {
		USER_CHANNELIDS.remove(userId);
	}

	public static boolean isContainChannelId(Object userId) {
		return USER_CHANNELIDS.containsKey(userId);
	}

	public static ChannelId getChannelId(Object userId) {
		return USER_CHANNELIDS.get(userId);
	}

	public static void add(Channel channel) {
		CHANNEL_GROUP.add(channel);
	}

	public static ChannelGroupFuture broadcast(Object msg) {
		return CHANNEL_GROUP.writeAndFlush(msg);
	}

	public static ChannelGroupFuture broadcast(Object msg, ChannelMatcher matcher) {
		return CHANNEL_GROUP.writeAndFlush(msg, matcher);
	}

	public static ChannelGroup flush() {
		return CHANNEL_GROUP.flush();
	}

	public static Channel getChannelByChannelId(ChannelId channelId) {
		return CHANNEL_GROUP.find(channelId);
	}

	public static Channel getChannelByUserId(Object userId) {
		return CHANNEL_GROUP.find(getChannelId(userId));
	}

	public static boolean remove(Channel channel) {
		return CHANNEL_GROUP.remove(channel);
	}

	public static ChannelGroupFuture disconnect() {
		return CHANNEL_GROUP.disconnect();
	}

	public static ChannelGroupFuture disconnect(ChannelMatcher matcher) {
		return CHANNEL_GROUP.disconnect(matcher);
	}

	public static boolean contains(Channel channel) {
		return CHANNEL_GROUP.contains(channel);
	}

	public static int size() {
		return CHANNEL_GROUP.size();
	}
}