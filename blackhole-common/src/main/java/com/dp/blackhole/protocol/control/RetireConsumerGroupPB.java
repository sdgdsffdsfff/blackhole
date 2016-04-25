// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RetireConsumerGroup.proto

package com.dp.blackhole.protocol.control;

public final class RetireConsumerGroupPB {
  private RetireConsumerGroupPB() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface RetireConsumerGroupOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required string topic = 1;
    /**
     * <code>required string topic = 1;</code>
     */
    boolean hasTopic();
    /**
     * <code>required string topic = 1;</code>
     */
    java.lang.String getTopic();
    /**
     * <code>required string topic = 1;</code>
     */
    com.google.protobuf.ByteString
        getTopicBytes();

    // required string groupId = 2;
    /**
     * <code>required string groupId = 2;</code>
     */
    boolean hasGroupId();
    /**
     * <code>required string groupId = 2;</code>
     */
    java.lang.String getGroupId();
    /**
     * <code>required string groupId = 2;</code>
     */
    com.google.protobuf.ByteString
        getGroupIdBytes();
  }
  /**
   * Protobuf type {@code blackhole.RetireConsumerGroup}
   */
  public static final class RetireConsumerGroup extends
      com.google.protobuf.GeneratedMessage
      implements RetireConsumerGroupOrBuilder {
    // Use RetireConsumerGroup.newBuilder() to construct.
    private RetireConsumerGroup(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private RetireConsumerGroup(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final RetireConsumerGroup defaultInstance;
    public static RetireConsumerGroup getDefaultInstance() {
      return defaultInstance;
    }

    public RetireConsumerGroup getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private RetireConsumerGroup(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
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
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              topic_ = input.readBytes();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              groupId_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dp.blackhole.protocol.control.RetireConsumerGroupPB.internal_static_blackhole_RetireConsumerGroup_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dp.blackhole.protocol.control.RetireConsumerGroupPB.internal_static_blackhole_RetireConsumerGroup_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup.class, com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup.Builder.class);
    }

    public static com.google.protobuf.Parser<RetireConsumerGroup> PARSER =
        new com.google.protobuf.AbstractParser<RetireConsumerGroup>() {
      public RetireConsumerGroup parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new RetireConsumerGroup(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<RetireConsumerGroup> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required string topic = 1;
    public static final int TOPIC_FIELD_NUMBER = 1;
    private java.lang.Object topic_;
    /**
     * <code>required string topic = 1;</code>
     */
    public boolean hasTopic() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string topic = 1;</code>
     */
    public java.lang.String getTopic() {
      java.lang.Object ref = topic_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          topic_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string topic = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTopicBytes() {
      java.lang.Object ref = topic_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        topic_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required string groupId = 2;
    public static final int GROUPID_FIELD_NUMBER = 2;
    private java.lang.Object groupId_;
    /**
     * <code>required string groupId = 2;</code>
     */
    public boolean hasGroupId() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string groupId = 2;</code>
     */
    public java.lang.String getGroupId() {
      java.lang.Object ref = groupId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          groupId_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string groupId = 2;</code>
     */
    public com.google.protobuf.ByteString
        getGroupIdBytes() {
      java.lang.Object ref = groupId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        groupId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      topic_ = "";
      groupId_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasTopic()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasGroupId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getTopicBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getGroupIdBytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getTopicBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getGroupIdBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code blackhole.RetireConsumerGroup}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroupOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.dp.blackhole.protocol.control.RetireConsumerGroupPB.internal_static_blackhole_RetireConsumerGroup_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.dp.blackhole.protocol.control.RetireConsumerGroupPB.internal_static_blackhole_RetireConsumerGroup_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup.class, com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup.Builder.class);
      }

      // Construct using com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        topic_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        groupId_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.dp.blackhole.protocol.control.RetireConsumerGroupPB.internal_static_blackhole_RetireConsumerGroup_descriptor;
      }

      public com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup getDefaultInstanceForType() {
        return com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup.getDefaultInstance();
      }

      public com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup build() {
        com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup buildPartial() {
        com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup result = new com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.topic_ = topic_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.groupId_ = groupId_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup) {
          return mergeFrom((com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup other) {
        if (other == com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup.getDefaultInstance()) return this;
        if (other.hasTopic()) {
          bitField0_ |= 0x00000001;
          topic_ = other.topic_;
          onChanged();
        }
        if (other.hasGroupId()) {
          bitField0_ |= 0x00000002;
          groupId_ = other.groupId_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasTopic()) {
          
          return false;
        }
        if (!hasGroupId()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.dp.blackhole.protocol.control.RetireConsumerGroupPB.RetireConsumerGroup) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required string topic = 1;
      private java.lang.Object topic_ = "";
      /**
       * <code>required string topic = 1;</code>
       */
      public boolean hasTopic() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public java.lang.String getTopic() {
        java.lang.Object ref = topic_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          topic_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public com.google.protobuf.ByteString
          getTopicBytes() {
        java.lang.Object ref = topic_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          topic_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public Builder setTopic(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        topic_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public Builder clearTopic() {
        bitField0_ = (bitField0_ & ~0x00000001);
        topic_ = getDefaultInstance().getTopic();
        onChanged();
        return this;
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public Builder setTopicBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        topic_ = value;
        onChanged();
        return this;
      }

      // required string groupId = 2;
      private java.lang.Object groupId_ = "";
      /**
       * <code>required string groupId = 2;</code>
       */
      public boolean hasGroupId() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string groupId = 2;</code>
       */
      public java.lang.String getGroupId() {
        java.lang.Object ref = groupId_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          groupId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string groupId = 2;</code>
       */
      public com.google.protobuf.ByteString
          getGroupIdBytes() {
        java.lang.Object ref = groupId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          groupId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string groupId = 2;</code>
       */
      public Builder setGroupId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        groupId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string groupId = 2;</code>
       */
      public Builder clearGroupId() {
        bitField0_ = (bitField0_ & ~0x00000002);
        groupId_ = getDefaultInstance().getGroupId();
        onChanged();
        return this;
      }
      /**
       * <code>required string groupId = 2;</code>
       */
      public Builder setGroupIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        groupId_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:blackhole.RetireConsumerGroup)
    }

    static {
      defaultInstance = new RetireConsumerGroup(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:blackhole.RetireConsumerGroup)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_blackhole_RetireConsumerGroup_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_blackhole_RetireConsumerGroup_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031RetireConsumerGroup.proto\022\tblackhole\"5" +
      "\n\023RetireConsumerGroup\022\r\n\005topic\030\001 \002(\t\022\017\n\007" +
      "groupId\030\002 \002(\tB:\n!com.dp.blackhole.protoc" +
      "ol.controlB\025RetireConsumerGroupPB"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_blackhole_RetireConsumerGroup_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_blackhole_RetireConsumerGroup_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_blackhole_RetireConsumerGroup_descriptor,
              new java.lang.String[] { "Topic", "GroupId", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
