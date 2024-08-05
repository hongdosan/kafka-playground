package kr.co.kafkaplayground.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProducerConstant {

	public static final String BOOTSTRAP_SERVERS = "bootstrap.servers";
	public static final String BOOTSTRAP_SERVERS_LOCAL = "127.0.0.1:9092";
	public static final String SERIALIZER_KEY = "key.serializer";
	public static final String SERIALIZER_VALUE = "value.serializer";
	public static final String SERIALIZER_STRING = "org.apache.kafka.common.serialization.StringSerializer";
	public static final String TOPIC_BASIC_01 = "peter-basic01";
	public static final String RECORD_MESSAGE = "Apache Kafka is a distributed streaming platform - ";
	public static final String TOPIC_MESSAGE = "======= Topic: ";
	public static final String PARTITION_MESSAGE = "======= Partition: ";
	public static final String OFFSET_MESSAGE = "======= Offset: ";
	public static final String KEY_MESSAGE = "======= Key: ";
	public static final String RECEIVED_MESSAGE = "======= Received Message: ";
}
