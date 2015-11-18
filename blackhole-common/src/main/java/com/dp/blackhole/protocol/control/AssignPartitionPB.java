// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: AssignPartition.proto

package com.dp.blackhole.protocol.control;

public final class AssignPartitionPB {
  private AssignPartitionPB() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface AssignPartitionOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // repeated .blackhole.AssignBroker assigns = 1;
    /**
     * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
     */
    java.util.List<com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker> 
        getAssignsList();
    /**
     * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
     */
    com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker getAssigns(int index);
    /**
     * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
     */
    int getAssignsCount();
    /**
     * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
     */
    java.util.List<? extends com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBrokerOrBuilder> 
        getAssignsOrBuilderList();
    /**
     * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
     */
    com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBrokerOrBuilder getAssignsOrBuilder(
        int index);
  }
  /**
   * Protobuf type {@code blackhole.AssignPartition}
   */
  public static final class AssignPartition extends
      com.google.protobuf.GeneratedMessage
      implements AssignPartitionOrBuilder {
    // Use AssignPartition.newBuilder() to construct.
    private AssignPartition(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private AssignPartition(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final AssignPartition defaultInstance;
    public static AssignPartition getDefaultInstance() {
      return defaultInstance;
    }

    public AssignPartition getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private AssignPartition(
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
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                assigns_ = new java.util.ArrayList<com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker>();
                mutable_bitField0_ |= 0x00000001;
              }
              assigns_.add(input.readMessage(com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker.PARSER, extensionRegistry));
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
        if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
          assigns_ = java.util.Collections.unmodifiableList(assigns_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dp.blackhole.protocol.control.AssignPartitionPB.internal_static_blackhole_AssignPartition_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dp.blackhole.protocol.control.AssignPartitionPB.internal_static_blackhole_AssignPartition_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition.class, com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition.Builder.class);
    }

    public static com.google.protobuf.Parser<AssignPartition> PARSER =
        new com.google.protobuf.AbstractParser<AssignPartition>() {
      public AssignPartition parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new AssignPartition(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<AssignPartition> getParserForType() {
      return PARSER;
    }

    // repeated .blackhole.AssignBroker assigns = 1;
    public static final int ASSIGNS_FIELD_NUMBER = 1;
    private java.util.List<com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker> assigns_;
    /**
     * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
     */
    public java.util.List<com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker> getAssignsList() {
      return assigns_;
    }
    /**
     * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
     */
    public java.util.List<? extends com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBrokerOrBuilder> 
        getAssignsOrBuilderList() {
      return assigns_;
    }
    /**
     * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
     */
    public int getAssignsCount() {
      return assigns_.size();
    }
    /**
     * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
     */
    public com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker getAssigns(int index) {
      return assigns_.get(index);
    }
    /**
     * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
     */
    public com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBrokerOrBuilder getAssignsOrBuilder(
        int index) {
      return assigns_.get(index);
    }

    private void initFields() {
      assigns_ = java.util.Collections.emptyList();
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      for (int i = 0; i < getAssignsCount(); i++) {
        if (!getAssigns(i).isInitialized()) {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      for (int i = 0; i < assigns_.size(); i++) {
        output.writeMessage(1, assigns_.get(i));
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < assigns_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, assigns_.get(i));
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

    public static com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition prototype) {
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
     * Protobuf type {@code blackhole.AssignPartition}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartitionOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.dp.blackhole.protocol.control.AssignPartitionPB.internal_static_blackhole_AssignPartition_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.dp.blackhole.protocol.control.AssignPartitionPB.internal_static_blackhole_AssignPartition_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition.class, com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition.Builder.class);
      }

      // Construct using com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition.newBuilder()
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
          getAssignsFieldBuilder();
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        if (assignsBuilder_ == null) {
          assigns_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          assignsBuilder_.clear();
        }
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.dp.blackhole.protocol.control.AssignPartitionPB.internal_static_blackhole_AssignPartition_descriptor;
      }

      public com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition getDefaultInstanceForType() {
        return com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition.getDefaultInstance();
      }

      public com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition build() {
        com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition buildPartial() {
        com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition result = new com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition(this);
        int from_bitField0_ = bitField0_;
        if (assignsBuilder_ == null) {
          if (((bitField0_ & 0x00000001) == 0x00000001)) {
            assigns_ = java.util.Collections.unmodifiableList(assigns_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.assigns_ = assigns_;
        } else {
          result.assigns_ = assignsBuilder_.build();
        }
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition) {
          return mergeFrom((com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition other) {
        if (other == com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition.getDefaultInstance()) return this;
        if (assignsBuilder_ == null) {
          if (!other.assigns_.isEmpty()) {
            if (assigns_.isEmpty()) {
              assigns_ = other.assigns_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureAssignsIsMutable();
              assigns_.addAll(other.assigns_);
            }
            onChanged();
          }
        } else {
          if (!other.assigns_.isEmpty()) {
            if (assignsBuilder_.isEmpty()) {
              assignsBuilder_.dispose();
              assignsBuilder_ = null;
              assigns_ = other.assigns_;
              bitField0_ = (bitField0_ & ~0x00000001);
              assignsBuilder_ = 
                com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                   getAssignsFieldBuilder() : null;
            } else {
              assignsBuilder_.addAllMessages(other.assigns_);
            }
          }
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        for (int i = 0; i < getAssignsCount(); i++) {
          if (!getAssigns(i).isInitialized()) {
            
            return false;
          }
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.dp.blackhole.protocol.control.AssignPartitionPB.AssignPartition) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // repeated .blackhole.AssignBroker assigns = 1;
      private java.util.List<com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker> assigns_ =
        java.util.Collections.emptyList();
      private void ensureAssignsIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          assigns_ = new java.util.ArrayList<com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker>(assigns_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilder<
          com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker, com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker.Builder, com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBrokerOrBuilder> assignsBuilder_;

      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public java.util.List<com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker> getAssignsList() {
        if (assignsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(assigns_);
        } else {
          return assignsBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public int getAssignsCount() {
        if (assignsBuilder_ == null) {
          return assigns_.size();
        } else {
          return assignsBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker getAssigns(int index) {
        if (assignsBuilder_ == null) {
          return assigns_.get(index);
        } else {
          return assignsBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public Builder setAssigns(
          int index, com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker value) {
        if (assignsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureAssignsIsMutable();
          assigns_.set(index, value);
          onChanged();
        } else {
          assignsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public Builder setAssigns(
          int index, com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker.Builder builderForValue) {
        if (assignsBuilder_ == null) {
          ensureAssignsIsMutable();
          assigns_.set(index, builderForValue.build());
          onChanged();
        } else {
          assignsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public Builder addAssigns(com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker value) {
        if (assignsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureAssignsIsMutable();
          assigns_.add(value);
          onChanged();
        } else {
          assignsBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public Builder addAssigns(
          int index, com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker value) {
        if (assignsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureAssignsIsMutable();
          assigns_.add(index, value);
          onChanged();
        } else {
          assignsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public Builder addAssigns(
          com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker.Builder builderForValue) {
        if (assignsBuilder_ == null) {
          ensureAssignsIsMutable();
          assigns_.add(builderForValue.build());
          onChanged();
        } else {
          assignsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public Builder addAssigns(
          int index, com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker.Builder builderForValue) {
        if (assignsBuilder_ == null) {
          ensureAssignsIsMutable();
          assigns_.add(index, builderForValue.build());
          onChanged();
        } else {
          assignsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public Builder addAllAssigns(
          java.lang.Iterable<? extends com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker> values) {
        if (assignsBuilder_ == null) {
          ensureAssignsIsMutable();
          super.addAll(values, assigns_);
          onChanged();
        } else {
          assignsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public Builder clearAssigns() {
        if (assignsBuilder_ == null) {
          assigns_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          assignsBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public Builder removeAssigns(int index) {
        if (assignsBuilder_ == null) {
          ensureAssignsIsMutable();
          assigns_.remove(index);
          onChanged();
        } else {
          assignsBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker.Builder getAssignsBuilder(
          int index) {
        return getAssignsFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBrokerOrBuilder getAssignsOrBuilder(
          int index) {
        if (assignsBuilder_ == null) {
          return assigns_.get(index);  } else {
          return assignsBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public java.util.List<? extends com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBrokerOrBuilder> 
           getAssignsOrBuilderList() {
        if (assignsBuilder_ != null) {
          return assignsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(assigns_);
        }
      }
      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker.Builder addAssignsBuilder() {
        return getAssignsFieldBuilder().addBuilder(
            com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker.getDefaultInstance());
      }
      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker.Builder addAssignsBuilder(
          int index) {
        return getAssignsFieldBuilder().addBuilder(
            index, com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker.getDefaultInstance());
      }
      /**
       * <code>repeated .blackhole.AssignBroker assigns = 1;</code>
       */
      public java.util.List<com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker.Builder> 
           getAssignsBuilderList() {
        return getAssignsFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilder<
          com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker, com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker.Builder, com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBrokerOrBuilder> 
          getAssignsFieldBuilder() {
        if (assignsBuilder_ == null) {
          assignsBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
              com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker, com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBroker.Builder, com.dp.blackhole.protocol.control.AssignBrokerPB.AssignBrokerOrBuilder>(
                  assigns_,
                  ((bitField0_ & 0x00000001) == 0x00000001),
                  getParentForChildren(),
                  isClean());
          assigns_ = null;
        }
        return assignsBuilder_;
      }

      // @@protoc_insertion_point(builder_scope:blackhole.AssignPartition)
    }

    static {
      defaultInstance = new AssignPartition(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:blackhole.AssignPartition)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_blackhole_AssignPartition_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_blackhole_AssignPartition_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025AssignPartition.proto\022\tblackhole\032\022Assi" +
      "gnBroker.proto\";\n\017AssignPartition\022(\n\007ass" +
      "igns\030\001 \003(\0132\027.blackhole.AssignBrokerB6\n!c" +
      "om.dp.blackhole.protocol.controlB\021Assign" +
      "PartitionPB"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_blackhole_AssignPartition_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_blackhole_AssignPartition_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_blackhole_AssignPartition_descriptor,
              new java.lang.String[] { "Assigns", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.dp.blackhole.protocol.control.AssignBrokerPB.getDescriptor(),
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}