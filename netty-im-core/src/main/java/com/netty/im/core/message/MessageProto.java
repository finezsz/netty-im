package com.netty.im.core.message;

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: netty-im-core/src/main/java/com/netty/im/core/message/Message.proto

public final class MessageProto {
  private MessageProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface MessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Message)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string id = 1;</code>
     */
    java.lang.String getId();
    /**
     * <code>string id = 1;</code>
     */
    com.google.protobuf.ByteString
        getIdBytes();

    /**
     * <pre>
     *1：心跳消息  ，2：接收成功回执，3：单聊消息，4：群聊消息，5：广播消息，6：在线音频、7：在线视频
     * </pre>
     *
     * <code>int32 messageType = 2;</code>
     */
    int getMessageType();

    /**
     * <pre>
     *1：文本消息、2：图片消息、3：音频消息、4：视频消息、5：红包消息
     * </pre>
     *
     * <code>int32 contentType = 3;</code>
     */
    int getContentType();

    /**
     * <code>string content = 4;</code>
     */
    java.lang.String getContent();
    /**
     * <code>string content = 4;</code>
     */
    com.google.protobuf.ByteString
        getContentBytes();

    /**
     * <code>int64 receiver = 5;</code>
     */
    long getReceiver();

    /**
     * <code>int64 sender = 6;</code>
     */
    long getSender();

    /**
     * <pre>
     *鉴权令牌
     * </pre>
     *
     * <code>string token = 7;</code>
     */
    java.lang.String getToken();
    /**
     * <pre>
     *鉴权令牌
     * </pre>
     *
     * <code>string token = 7;</code>
     */
    com.google.protobuf.ByteString
        getTokenBytes();

    /**
     * <pre>
     *服务器端接收到的时间
     * </pre>
     *
     * <code>int64 timeMillis = 8;</code>
     */
    long getTimeMillis();
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\nCnetty-im-core/src/main/java/com/netty/" +
      "im/core/message/Message.proto\"\225\001\n\007Messag" +
      "e\022\n\n\002id\030\001 \001(\t\022\023\n\013messageType\030\002 \001(\005\022\023\n\013co" +
      "ntentType\030\003 \001(\005\022\017\n\007content\030\004 \001(\t\022\020\n\010rece" +
      "iver\030\005 \001(\003\022\016\n\006sender\030\006 \001(\003\022\r\n\005token\030\007 \001(" +
      "\t\022\022\n\ntimeMillis\030\010 \001(\003B\016B\014MessageProtob\006p" +
      "roto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Message_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_descriptor,
        new java.lang.String[] { "Id", "MessageType", "ContentType", "Content", "Receiver", "Sender", "Token", "TimeMillis", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}