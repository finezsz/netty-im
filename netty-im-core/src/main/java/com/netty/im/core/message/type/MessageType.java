package com.netty.im.core.message.type;

/**
 * 消息类型
 * 
 * @author pc
 *
 */
public enum MessageType {
	// 1：心跳消息 ，2：接收成功回执，3：单聊消息，4：群聊消息，5：广播消息，6：在线音频、7：在线视频
	HEART_BEAT(1, "心跳消息"), RECEIVE_SUCCESS(2, "接收成功回执"), SINGLE_MESSAGE(3, "单聊消息"), GROUP_MESSAGE(4,
			"群聊消息"), BROADCAST_MESSAGE(5, "广播消息"), ONLINE_AUDIO(6, "在线音频"), ONLINE_VEDIO(7, "在线视频");

	MessageType(int type, String description) {
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
