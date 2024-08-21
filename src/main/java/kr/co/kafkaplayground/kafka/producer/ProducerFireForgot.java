package kr.co.kafkaplayground.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import kr.co.kafkaplayground.common.constant.ProducerConstant;
import kr.co.kafkaplayground.error.model.ErrorMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProducerFireForgot {

	public static void main(String[] args) {
		final Properties properties = generateProperties();

		try (Producer<String, String> producer = new KafkaProducer<>(properties)) {
			for (int i = 0; i < 3; i++) {
				ProducerRecord<String, String> producerRecord =
					new ProducerRecord<>(ProducerConstant.TOPIC_BASIC_01, ProducerConstant.RECORD_MESSAGE + i);
				producer.send(producerRecord);
			}
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
