package kr.co.kafkaplayground.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import kr.co.kafkaplayground.common.constant.Constant;
import kr.co.kafkaplayground.common.constant.ProducerConstant;
import kr.co.kafkaplayground.error.model.ErrorMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProducerSync {

	public static void main(String[] args) {
		final Properties properties = generateProperties();

		try (Producer<String, String> producer = new KafkaProducer<>(properties)) {
			for (int i = 0; i < 3; i++) {
				ProducerRecord<String, String> producerRecord =
					new ProducerRecord<>(ProducerConstant.TOPIC_BASIC_01, ProducerConstant.RECORD_MESSAGE + i);
				RecordMetadata recordMetadata = producer.send(producerRecord).get();

				log.info(ProducerConstant.TOPIC_MESSAGE + recordMetadata.topic());
				log.info(ProducerConstant.PARTITION_MESSAGE + recordMetadata.partition());
				log.info(ProducerConstant.OFFSET_MESSAGE + recordMetadata.offset());
				log.info(ProducerConstant.KEY_MESSAGE + producerRecord.key());
				log.info(ProducerConstant.RECEIVED_MESSAGE + producerRecord.value() + Constant.NEWLINE);
			}
		} catch (InterruptedException e) {
			log.error(ErrorMessage.INTERRUPTED.getMessage() + e);
			Thread.currentThread().interrupt();
		} catch (Exception e) {
			log.error(ErrorMessage.BASE.getMessage() + e);
		}
	}

	private static Properties generateProperties() {
		Properties properties = new Properties();
		properties.put(ProducerConstant.BOOTSTRAP_SERVERS, ProducerConstant.BOOTSTRAP_SERVERS_LOCAL);
		properties.put(ProducerConstant.SERIALIZER_KEY, ProducerConstant.SERIALIZER_STRING);
		properties.put(ProducerConstant.SERIALIZER_VALUE, ProducerConstant.SERIALIZER_STRING);

		return properties;
	}
}
