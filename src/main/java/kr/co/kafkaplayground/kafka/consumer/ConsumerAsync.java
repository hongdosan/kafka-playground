package kr.co.kafkaplayground.kafka.consumer;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import kr.co.kafkaplayground.common.constant.Constant;
import kr.co.kafkaplayground.common.constant.ConsumerConstant;
import kr.co.kafkaplayground.error.model.ErrorMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsumerAsync {

	public static void main(String[] args) {
		final Properties properties = generateProperties();

		try (Consumer<String, String> consumer = new KafkaConsumer<>(properties)) {
			consumer.subscribe(List.of(ConsumerConstant.TOPIC_BASIC_01));

			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));

				for (ConsumerRecord<String, String> consumerRecord : records) {
					log.info(ConsumerConstant.TOPIC_MESSAGE + consumerRecord.topic());
					log.info(ConsumerConstant.PARTITION_MESSAGE + consumerRecord.partition());
					log.info(ConsumerConstant.OFFSET_MESSAGE + consumerRecord.offset());
					log.info(ConsumerConstant.KEY_MESSAGE + consumerRecord.key());
					log.info(ConsumerConstant.VALUE_MESSAGE + consumerRecord.value() + Constant.NEWLINE);
				}

				consumer.commitAsync();
			}
		} catch (Exception e) {
			log.error(ErrorMessage.BASE.getMessage() + e);
		}
	}

	private static Properties generateProperties() {
		Properties properties = new Properties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, ConsumerConstant.BOOTSTRAP_SERVERS_LOCAL);
		properties.put(ConsumerConstant.GROUP_ID, ConsumerConstant.GROUP_CONSUMER_01);
		properties.put(ConsumerConstant.ENABLE_AUTO_COMMIT, false);
		properties.put(ConsumerConstant.AUTO_OFFSET_RESET, ConsumerConstant.LATEST);
		properties.put(ConsumerConstant.DESERIALIZER_KEY, ConsumerConstant.DESERIALIZER_STRING);
		properties.put(ConsumerConstant.DESERIALIZER_VALUE, ConsumerConstant.DESERIALIZER_STRING);

		return properties;
	}
}
