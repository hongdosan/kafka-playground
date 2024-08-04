package kr.co.kafkaplayground.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import kr.co.kafkaplayground.common.constant.Constant;
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
				ProducerRecord<String, String> producerRecord
					= new ProducerRecord<>(KafkaConstant.BASIC_TOPIC, KafkaConstant.BASIC_MESSAGE + i);
				RecordMetadata recordMetadata = producer.send(producerRecord).get();

				log.info(KafkaConstant.TOPIC + recordMetadata.topic());
				log.info(KafkaConstant.PARTITION + recordMetadata.partition());
				log.info(KafkaConstant.OFFSET + recordMetadata.offset());
				log.info(KafkaConstant.KEY + producerRecord.key());
				log.info(KafkaConstant.RECEIVED_MESSAGE + producerRecord.value() + Constant.NEWLINE);
			}
		} catch (InterruptedException e) {
			log.error(ErrorMessage.INTERRUPTED.getMessage() + e);
			Thread.currentThread().interrupt();
		} catch (Exception e) {
			log.error(ErrorMessage.BASE.getMessage() + e);
		}
	}
}
