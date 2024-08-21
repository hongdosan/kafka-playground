package kr.co.kafkaplayground.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import kr.co.kafkaplayground.common.constant.ProducerConstant;
import kr.co.kafkaplayground.error.model.ErrorMessage;
import kr.co.kafkaplayground.kafka.callback.PeterProducerCallback;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProducerAsync {

	public static void main(String[] args) {
		final Properties properties = generateProperties();

		try (Producer<String, String> producer = new KafkaProducer<>(properties)) {
			for (int i = 0; i < 3; i++) {
				ProducerRecord<String, String> producerRecord =
					new ProducerRecord<>(ProducerConstant.TOPIC_BASIC_01, ProducerConstant.RECORD_MESSAGE + i);
				producer.send(producerRecord, new PeterProducerCallback(producerRecord));
			}
		} catch (Exception e) {
			log.error(ErrorMessage.BASE.getMessage() + e);
		}
	}

	private static Properties generateProperties() {
		Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, ProducerConstant.BOOTSTRAP_SERVERS_LOCAL);
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, ProducerConstant.SERIALIZER_STRING);
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ProducerConstant.SERIALIZER_STRING);

		return properties;
	}
}
