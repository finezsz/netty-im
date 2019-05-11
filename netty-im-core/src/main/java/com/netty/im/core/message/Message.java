package com.netty.im.core.message;

import com.netty.im.core.message.MessageProto.MessageOrBuilder;

/**
   * Protobuf type {@code Message}
   */
  public  final class Message extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Message)
      MessageOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Message.newBuilder() to construct.
    private Message(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Message() {
      id_ = "";
      messageType_ = 0;
      contentType_ = 0;
      content_ = "";
      receiver_ = 0L;
      sender_ = 0L;
      token_ = "";
      timeMillis_ = 0L;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Message(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              id_ = s;
              break;
            }
            case 16: {

              messageType_ = input.readInt32();
              break;
            }
            case 24: {

              contentType_ = input.readInt32();
              break;
            }
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();

              content_ = s;
              break;
            }
            case 40: {

              receiver_ = input.readInt64();
              break;
            }
            case 48: {

              sender_ = input.readInt64();
              break;
            }
            case 58: {
              java.lang.String s = input.readStringRequireUtf8();

              token_ = s;
              break;
            }
            case 64: {

              timeMillis_ = input.readInt64();
              break;
            }
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MessageProto.internal_static_Message_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MessageProto.internal_static_Message_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Message.class, Message.Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private volatile java.lang.Object id_;
    /**
     * <code>string id = 1;</code>
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        id_ = s;
        return s;
      }
    }
    /**
     * <code>string id = 1;</code>
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MESSAGETYPE_FIELD_NUMBER = 2;
    private int messageType_;
    /**
     * <pre>
     *1：心跳消息  ，2：接收成功回执，3：单聊消息，4：群聊消息，5：广播消息，6：在线音频、7：在线视频
     * </pre>
     *
     * <code>int32 messageType = 2;</code>
     */
    public int getMessageType() {
      return messageType_;
    }

    public static final int CONTENTTYPE_FIELD_NUMBER = 3;
    private int contentType_;
    /**
     * <pre>
     *1：文本消息、2：图片消息、3：音频消息、4：视频消息、5：红包消息
     * </pre>
     *
     * <code>int32 contentType = 3;</code>
     */
    public int getContentType() {
      return contentType_;
    }

    public static final int CONTENT_FIELD_NUMBER = 4;
    private volatile java.lang.Object content_;
    /**
     * <code>string content = 4;</code>
     */
    public java.lang.String getContent() {
      java.lang.Object ref = content_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        content_ = s;
        return s;
      }
    }
    /**
     * <code>string content = 4;</code>
     */
    public com.google.protobuf.ByteString
        getContentBytes() {
      java.lang.Object ref = content_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        content_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int RECEIVER_FIELD_NUMBER = 5;
    private long receiver_;
    /**
     * <code>int64 receiver = 5;</code>
     */
    public long getReceiver() {
      return receiver_;
    }

    public static final int SENDER_FIELD_NUMBER = 6;
    private long sender_;
    /**
     * <code>int64 sender = 6;</code>
     */
    public long getSender() {
      return sender_;
    }

    public static final int TOKEN_FIELD_NUMBER = 7;
    private volatile java.lang.Object token_;
    /**
     * <pre>
     *鉴权令牌
     * </pre>
     *
     * <code>string token = 7;</code>
     */
    public java.lang.String getToken() {
      java.lang.Object ref = token_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        token_ = s;
        return s;
      }
    }
    /**
     * <pre>
     *鉴权令牌
     * </pre>
     *
     * <code>string token = 7;</code>
     */
    public com.google.protobuf.ByteString
        getTokenBytes() {
      java.lang.Object ref = token_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        token_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TIMEMILLIS_FIELD_NUMBER = 8;
    private long timeMillis_;
    /**
     * <pre>
     *服务器端接收到的时间
     * </pre>
     *
     * <code>int64 timeMillis = 8;</code>
     */
    public long getTimeMillis() {
      return timeMillis_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
      }
      if (messageType_ != 0) {
        output.writeInt32(2, messageType_);
      }
      if (contentType_ != 0) {
        output.writeInt32(3, contentType_);
      }
      if (!getContentBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, content_);
      }
      if (receiver_ != 0L) {
        output.writeInt64(5, receiver_);
      }
      if (sender_ != 0L) {
        output.writeInt64(6, sender_);
      }
      if (!getTokenBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 7, token_);
      }
      if (timeMillis_ != 0L) {
        output.writeInt64(8, timeMillis_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
      }
      if (messageType_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, messageType_);
      }
      if (contentType_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, contentType_);
      }
      if (!getContentBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, content_);
      }
      if (receiver_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(5, receiver_);
      }
      if (sender_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(6, sender_);
      }
      if (!getTokenBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, token_);
      }
      if (timeMillis_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(8, timeMillis_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Message)) {
        return super.equals(obj);
      }
      Message other = (Message) obj;

      boolean result = true;
      result = result && getId()
          .equals(other.getId());
      result = result && (getMessageType()
          == other.getMessageType());
      result = result && (getContentType()
          == other.getContentType());
      result = result && getContent()
          .equals(other.getContent());
      result = result && (getReceiver()
          == other.getReceiver());
      result = result && (getSender()
          == other.getSender());
      result = result && getToken()
          .equals(other.getToken());
      result = result && (getTimeMillis()
          == other.getTimeMillis());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getId().hashCode();
      hash = (37 * hash) + MESSAGETYPE_FIELD_NUMBER;
      hash = (53 * hash) + getMessageType();
      hash = (37 * hash) + CONTENTTYPE_FIELD_NUMBER;
      hash = (53 * hash) + getContentType();
      hash = (37 * hash) + CONTENT_FIELD_NUMBER;
      hash = (53 * hash) + getContent().hashCode();
      hash = (37 * hash) + RECEIVER_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getReceiver());
      hash = (37 * hash) + SENDER_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getSender());
      hash = (37 * hash) + TOKEN_FIELD_NUMBER;
      hash = (53 * hash) + getToken().hashCode();
      hash = (37 * hash) + TIMEMILLIS_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getTimeMillis());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Message parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Message parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Message parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Message parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Message parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Message parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Message parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Message parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Message parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Message parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Message parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Message parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Message.Builder newBuilderForType() { return newBuilder(); }
    public static Message.Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Message.Builder newBuilder(Message prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Message.Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Message.Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Message.Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Message}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Message.Builder> implements
        // @@protoc_insertion_point(builder_implements:Message)
        MessageProto.MessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return MessageProto.internal_static_Message_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return MessageProto.internal_static_Message_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Message.class, Message.Builder.class);
      }

      // Construct using MessageProto.Message.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Message.Builder clear() {
        super.clear();
        id_ = "";

        messageType_ = 0;

        contentType_ = 0;

        content_ = "";

        receiver_ = 0L;

        sender_ = 0L;

        token_ = "";

        timeMillis_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return MessageProto.internal_static_Message_descriptor;
      }

      @java.lang.Override
      public Message getDefaultInstanceForType() {
        return Message.getDefaultInstance();
      }

      @java.lang.Override
      public Message build() {
        Message result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public Message buildPartial() {
        Message result = new Message(this);
        result.id_ = id_;
        result.messageType_ = messageType_;
        result.contentType_ = contentType_;
        result.content_ = content_;
        result.receiver_ = receiver_;
        result.sender_ = sender_;
        result.token_ = token_;
        result.timeMillis_ = timeMillis_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Message.Builder clone() {
        return (Message.Builder) super.clone();
      }
      @java.lang.Override
      public Message.Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Message.Builder) super.setField(field, value);
      }
      @java.lang.Override
      public Message.Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Message.Builder) super.clearField(field);
      }
      @java.lang.Override
      public Message.Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Message.Builder) super.clearOneof(oneof);
      }
      @java.lang.Override
      public Message.Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Message.Builder) super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Message.Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Message.Builder) super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Message.Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Message) {
          return mergeFrom((Message)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Message.Builder mergeFrom(Message other) {
        if (other == Message.getDefaultInstance()) return this;
        if (!other.getId().isEmpty()) {
          id_ = other.id_;
          onChanged();
        }
        if (other.getMessageType() != 0) {
          setMessageType(other.getMessageType());
        }
        if (other.getContentType() != 0) {
          setContentType(other.getContentType());
        }
        if (!other.getContent().isEmpty()) {
          content_ = other.content_;
          onChanged();
        }
        if (other.getReceiver() != 0L) {
          setReceiver(other.getReceiver());
        }
        if (other.getSender() != 0L) {
          setSender(other.getSender());
        }
        if (!other.getToken().isEmpty()) {
          token_ = other.token_;
          onChanged();
        }
        if (other.getTimeMillis() != 0L) {
          setTimeMillis(other.getTimeMillis());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Message.Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Message parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Message) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object id_ = "";
      /**
       * <code>string id = 1;</code>
       */
      public java.lang.String getId() {
        java.lang.Object ref = id_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          id_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string id = 1;</code>
       */
      public com.google.protobuf.ByteString
          getIdBytes() {
        java.lang.Object ref = id_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          id_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string id = 1;</code>
       */
      public Message.Builder setId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string id = 1;</code>
       */
      public Message.Builder clearId() {
        
        id_ = getDefaultInstance().getId();
        onChanged();
        return this;
      }
      /**
       * <code>string id = 1;</code>
       */
      public Message.Builder setIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        id_ = value;
        onChanged();
        return this;
      }

      private int messageType_ ;
      /**
       * <pre>
       *1：心跳消息  ，2：接收成功回执，3：单聊消息，4：群聊消息，5：广播消息，6：在线音频、7：在线视频
       * </pre>
       *
       * <code>int32 messageType = 2;</code>
       */
      public int getMessageType() {
        return messageType_;
      }
      /**
       * <pre>
       *1：心跳消息  ，2：接收成功回执，3：单聊消息，4：群聊消息，5：广播消息，6：在线音频、7：在线视频
       * </pre>
       *
       * <code>int32 messageType = 2;</code>
       */
      public Message.Builder setMessageType(int value) {
        
        messageType_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *1：心跳消息  ，2：接收成功回执，3：单聊消息，4：群聊消息，5：广播消息，6：在线音频、7：在线视频
       * </pre>
       *
       * <code>int32 messageType = 2;</code>
       */
      public Message.Builder clearMessageType() {
        
        messageType_ = 0;
        onChanged();
        return this;
      }

      private int contentType_ ;
      /**
       * <pre>
       *1：文本消息、2：图片消息、3：音频消息、4：视频消息、5：红包消息
       * </pre>
       *
       * <code>int32 contentType = 3;</code>
       */
      public int getContentType() {
        return contentType_;
      }
      /**
       * <pre>
       *1：文本消息、2：图片消息、3：音频消息、4：视频消息、5：红包消息
       * </pre>
       *
       * <code>int32 contentType = 3;</code>
       */
      public Message.Builder setContentType(int value) {
        
        contentType_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *1：文本消息、2：图片消息、3：音频消息、4：视频消息、5：红包消息
       * </pre>
       *
       * <code>int32 contentType = 3;</code>
       */
      public Message.Builder clearContentType() {
        
        contentType_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object content_ = "";
      /**
       * <code>string content = 4;</code>
       */
      public java.lang.String getContent() {
        java.lang.Object ref = content_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          content_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string content = 4;</code>
       */
      public com.google.protobuf.ByteString
          getContentBytes() {
        java.lang.Object ref = content_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          content_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string content = 4;</code>
       */
      public Message.Builder setContent(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        content_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string content = 4;</code>
       */
      public Message.Builder clearContent() {
        
        content_ = getDefaultInstance().getContent();
        onChanged();
        return this;
      }
      /**
       * <code>string content = 4;</code>
       */
      public Message.Builder setContentBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        content_ = value;
        onChanged();
        return this;
      }

      private long receiver_ ;
      /**
       * <code>int64 receiver = 5;</code>
       */
      public long getReceiver() {
        return receiver_;
      }
      /**
       * <code>int64 receiver = 5;</code>
       */
      public Message.Builder setReceiver(long value) {
        
        receiver_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 receiver = 5;</code>
       */
      public Message.Builder clearReceiver() {
        
        receiver_ = 0L;
        onChanged();
        return this;
      }

      private long sender_ ;
      /**
       * <code>int64 sender = 6;</code>
       */
      public long getSender() {
        return sender_;
      }
      /**
       * <code>int64 sender = 6;</code>
       */
      public Message.Builder setSender(long value) {
        
        sender_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 sender = 6;</code>
       */
      public Message.Builder clearSender() {
        
        sender_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object token_ = "";
      /**
       * <pre>
       *鉴权令牌
       * </pre>
       *
       * <code>string token = 7;</code>
       */
      public java.lang.String getToken() {
        java.lang.Object ref = token_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          token_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       *鉴权令牌
       * </pre>
       *
       * <code>string token = 7;</code>
       */
      public com.google.protobuf.ByteString
          getTokenBytes() {
        java.lang.Object ref = token_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          token_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       *鉴权令牌
       * </pre>
       *
       * <code>string token = 7;</code>
       */
      public Message.Builder setToken(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        token_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *鉴权令牌
       * </pre>
       *
       * <code>string token = 7;</code>
       */
      public Message.Builder clearToken() {
        
        token_ = getDefaultInstance().getToken();
        onChanged();
        return this;
      }
      /**
       * <pre>
       *鉴权令牌
       * </pre>
       *
       * <code>string token = 7;</code>
       */
      public Message.Builder setTokenBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        token_ = value;
        onChanged();
        return this;
      }

      private long timeMillis_ ;
      /**
       * <pre>
       *服务器端接收到的时间
       * </pre>
       *
       * <code>int64 timeMillis = 8;</code>
       */
      public long getTimeMillis() {
        return timeMillis_;
      }
      /**
       * <pre>
       *服务器端接收到的时间
       * </pre>
       *
       * <code>int64 timeMillis = 8;</code>
       */
      public Message.Builder setTimeMillis(long value) {
        
        timeMillis_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *服务器端接收到的时间
       * </pre>
       *
       * <code>int64 timeMillis = 8;</code>
       */
      public Message.Builder clearTimeMillis() {
        
        timeMillis_ = 0L;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Message.Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      @java.lang.Override
      public final Message.Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:Message)
    }

    // @@protoc_insertion_point(class_scope:Message)
    private static final Message DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Message();
    }

    public static Message getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Message>
        PARSER = new com.google.protobuf.AbstractParser<Message>() {
      @java.lang.Override
      public Message parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Message(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Message> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Message> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public Message getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }