package kr.co.kafkaplayground.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KafkaConstant {

	public static final String BOOTSTRAP_SERVERS = "bootstrap.servers";
	public static final String BOOTSTRAP_SERVERS_VALUE = "127.0.0.1:9092";
	public static final String KEY_SERIALIZER = "key.serializer";
	public static final String VALUE_SERIALIZER = "value.serializer";
	public static final String SERIALIZER_VALUE = "org.apache.kafka.common.serialization.StringSerializer";
	public static final String BASIC_TOPIC = "peter-basic01";
	public static final String BASIC_MESSAGE = "Apache Kafka is a distributed streaming platform - ";
	public static final String TOPIC = "======= Topic: ";
	public static final String PARTITION = "======= Partition: ";
	public static final String OFFSET = "======= Offset: ";
	public static final String KEY = "======= Key: ";
	public static final String RECEIVED_MESSAGE = "======= Received Message: ";
}
