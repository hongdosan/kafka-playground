package kr.co.kafkaplayground.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import kr.co.kafkaplayground.common.constant.KafkaConstant;
import kr.co.kafkaplayground.common.error.model.ErrorMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProducerFireForgot {

	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.put(KafkaConstant.BOOTSTRAP_SERVERS, KafkaConstant.BOOTSTRAP_SERVERS_VALUE);
		properties.put(KafkaConstant.KEY_SERIALIZER, KafkaConstant.SERIALIZER_VALUE);
		properties.put(KafkaConstant.VALUE_SERIALIZER, KafkaConstant.SERIALIZER_VALUE);

		try (Producer<String, String> producer = new KafkaProducer<>(properties)) {
			for (int i = 0; i < 3; i++) {
				ProducerRecord<String, String> producerRecord =
					new ProducerRecord<>(KafkaConstant.BASIC_TOPIC, KafkaConstant.BASIC_MESSAGE + i);
				producer.send(producerRecord);
			}
		} catch (Exception e) {
			log.error(ErrorMessage.BASE.getMessage() + e);
		}
	}
}
