package com.netty.im.core.message.type;

/**
 * 内容类型
 * 
 * @author pc
 *
 */
public enum ContentType {
	TEXT(1, "文本消息"), IMAGE(2, "图片消息"), AUDIO(3, "音频消息"), VIDEO(4, "视频消息"), RED_PACKET(5, "红包消息");

	ContentType(int type, String description) {
		this.type = type;
		this.description = description;
	};

	public final int getType() {
		return type;
	}

	public final String getDescription() {
		return description;
	}

	private final int type;
	private final String description;
}
