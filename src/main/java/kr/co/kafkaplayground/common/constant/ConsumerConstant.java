package kr.co.kafkaplayground.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConsumerConstant {

	public static final String BOOTSTRAP_SERVERS_LOCAL = "127.0.0.1:9092";
	public static final String DESERIALIZER_KEY = "key.deserializer";
	public static final String DESERIALIZER_VALUE = "value.deserializer";
	public static final String DESERIALIZER_STRING = "org.apache.kafka.common.serialization.StringDeserializer";
	public static final String GROUP_ID = "group.id";
	public static final String GROUP_CONSUMER_01 = "peter-consumer01";
	public static final String ENABLE_AUTO_COMMIT = "enable.auto.commit";
	public static final String AUTO_OFFSET_RESET = "auto.offset.reset";
	public static final String LATEST = "latest";
	public static final String TOPIC_BASIC_01 = "peter-basic01";
	public static final String TOPIC_MESSAGE = "======= Topic: ";
	public static final String PARTITION_MESSAGE = "======= Partition: ";
	public static final String OFFSET_MESSAGE = "======= Offset: ";
	public static final String KEY_MESSAGE = "======= Key: ";
	public static final String VALUE_MESSAGE = "======= Value: ";
}
