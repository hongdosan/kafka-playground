package kr.co.kafkaplayground.kafka.callback;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import kr.co.kafkaplayground.common.constant.Constant;
import kr.co.kafkaplayground.common.constant.KafkaConstant;
import kr.co.kafkaplayground.common.error.model.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class PeterProducerCallback implements Callback {

	private final ProducerRecord<String, String> producerRecord;

	@Override
	public void onCompletion(RecordMetadata recordMetadata, Exception exception) {
		if (exception != null) {
			log.error(ErrorMessage.BASE.getMessage() + exception);
			return;
		}

		log.info(KafkaConstant.TOPIC + recordMetadata.topic());
		log.info(KafkaConstant.PARTITION + recordMetadata.partition());
		log.info(KafkaConstant.OFFSET + recordMetadata.offset());
		log.info(KafkaConstant.KEY + producerRecord.key());
		log.info(KafkaConstant.RECEIVED_MESSAGE + producerRecord.value() + Constant.NEWLINE);
	}
}
