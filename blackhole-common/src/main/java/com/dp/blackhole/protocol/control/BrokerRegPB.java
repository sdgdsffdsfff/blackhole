// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: BrokerReg.proto

package com.dp.blackhole.protocol.control;

public final class BrokerRegPB {
  private BrokerRegPB() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface BrokerRegOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required int32 broker_port = 1;
    /**
     * <code>required int32 broker_port = 1;</code>
     */
    boolean hasBrokerPort();
    /**
     * <code>required int32 broker_port = 1;</code>
     */
    int getBrokerPort();

    // required int32 recovery_port = 2;
    /**
     * <code>required int32 recovery_port = 2;</code>
     */
    boolean hasRecoveryPort();
    /**
     * <code>required int32 recovery_port = 2;</code>
     */
    int getRecoveryPort();
  }
  /**
   * Protobuf type {@code blackhole.BrokerReg}
   */
  public static final class BrokerReg extends
      com.google.protobuf.GeneratedMessage
      implements BrokerRegOrBuilder {
    // Use BrokerReg.newBuilder() to construct.
    private BrokerReg(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private BrokerReg(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final BrokerReg defaultInstance;
    public static BrokerReg getDefaultInstance() {
      return defaultInstance;
    }

    public BrokerReg getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private BrokerReg(
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
            case 8: {
              bitField0_ |= 0x00000001;
              brokerPort_ = input.readInt32();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              recoveryPort_ = input.readInt32();
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
      return com.dp.blackhole.protocol.control.BrokerRegPB.internal_static_blackhole_BrokerReg_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dp.blackhole.protocol.control.BrokerRegPB.internal_static_blackhole_BrokerReg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg.class, com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg.Builder.class);
    }

    public static com.google.protobuf.Parser<BrokerReg> PARSER =
        new com.google.protobuf.AbstractParser<BrokerReg>() {
      public BrokerReg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new BrokerReg(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<BrokerReg> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required int32 broker_port = 1;
    public static final int BROKER_PORT_FIELD_NUMBER = 1;
    private int brokerPort_;
    /**
     * <code>required int32 broker_port = 1;</code>
     */
    public boolean hasBrokerPort() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 broker_port = 1;</code>
     */
    public int getBrokerPort() {
      return brokerPort_;
    }

    // required int32 recovery_port = 2;
    public static final int RECOVERY_PORT_FIELD_NUMBER = 2;
    private int recoveryPort_;
    /**
     * <code>required int32 recovery_port = 2;</code>
     */
    public boolean hasRecoveryPort() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required int32 recovery_port = 2;</code>
     */
    public int getRecoveryPort() {
      return recoveryPort_;
    }

    private void initFields() {
      brokerPort_ = 0;
      recoveryPort_ = 0;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasBrokerPort()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasRecoveryPort()) {
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
        output.writeInt32(1, brokerPort_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt32(2, recoveryPort_);
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
          .computeInt32Size(1, brokerPort_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, recoveryPort_);
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

    public static com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg prototype) {
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
     * Protobuf type {@code blackhole.BrokerReg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.dp.blackhole.protocol.control.BrokerRegPB.BrokerRegOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.dp.blackhole.protocol.control.BrokerRegPB.internal_static_blackhole_BrokerReg_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.dp.blackhole.protocol.control.BrokerRegPB.internal_static_blackhole_BrokerReg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg.class, com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg.Builder.class);
      }

      // Construct using com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg.newBuilder()
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
        brokerPort_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        recoveryPort_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.dp.blackhole.protocol.control.BrokerRegPB.internal_static_blackhole_BrokerReg_descriptor;
      }

      public com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg getDefaultInstanceForType() {
        return com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg.getDefaultInstance();
      }

      public com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg build() {
        com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg buildPartial() {
        com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg result = new com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.brokerPort_ = brokerPort_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.recoveryPort_ = recoveryPort_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg) {
          return mergeFrom((com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg other) {
        if (other == com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg.getDefaultInstance()) return this;
        if (other.hasBrokerPort()) {
          setBrokerPort(other.getBrokerPort());
        }
        if (other.hasRecoveryPort()) {
          setRecoveryPort(other.getRecoveryPort());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasBrokerPort()) {
          
          return false;
        }
        if (!hasRecoveryPort()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.dp.blackhole.protocol.control.BrokerRegPB.BrokerReg) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required int32 broker_port = 1;
      private int brokerPort_ ;
      /**
       * <code>required int32 broker_port = 1;</code>
       */
      public boolean hasBrokerPort() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 broker_port = 1;</code>
       */
      public int getBrokerPort() {
        return brokerPort_;
      }
      /**
       * <code>required int32 broker_port = 1;</code>
       */
      public Builder setBrokerPort(int value) {
        bitField0_ |= 0x00000001;
        brokerPort_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 broker_port = 1;</code>
       */
      public Builder clearBrokerPort() {
        bitField0_ = (bitField0_ & ~0x00000001);
        brokerPort_ = 0;
        onChanged();
        return this;
      }

      // required int32 recovery_port = 2;
      private int recoveryPort_ ;
      /**
       * <code>required int32 recovery_port = 2;</code>
       */
      public boolean hasRecoveryPort() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required int32 recovery_port = 2;</code>
       */
      public int getRecoveryPort() {
        return recoveryPort_;
      }
      /**
       * <code>required int32 recovery_port = 2;</code>
       */
      public Builder setRecoveryPort(int value) {
        bitField0_ |= 0x00000002;
        recoveryPort_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 recovery_port = 2;</code>
       */
      public Builder clearRecoveryPort() {
        bitField0_ = (bitField0_ & ~0x00000002);
        recoveryPort_ = 0;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:blackhole.BrokerReg)
    }

    static {
      defaultInstance = new BrokerReg(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:blackhole.BrokerReg)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_blackhole_BrokerReg_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_blackhole_BrokerReg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017BrokerReg.proto\022\tblackhole\"7\n\tBrokerRe" +
      "g\022\023\n\013broker_port\030\001 \002(\005\022\025\n\rrecovery_port\030" +
      "\002 \002(\005B0\n!com.dp.blackhole.protocol.contr" +
      "olB\013BrokerRegPB"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_blackhole_BrokerReg_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_blackhole_BrokerReg_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_blackhole_BrokerReg_descriptor,
              new java.lang.String[] { "BrokerPort", "RecoveryPort", });
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
