package kr.co.kafkaplayground.kafka.callback;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import kr.co.kafkaplayground.common.constant.Constant;
import kr.co.kafkaplayground.common.constant.ProducerConstant;
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

		log.info(ProducerConstant.TOPIC_MESSAGE + recordMetadata.topic());
		log.info(ProducerConstant.PARTITION_MESSAGE + recordMetadata.partition());
		log.info(ProducerConstant.OFFSET_MESSAGE + recordMetadata.offset());
		log.info(ProducerConstant.KEY_MESSAGE + producerRecord.key());
		log.info(ProducerConstant.RECEIVED_MESSAGE + producerRecord.value() + Constant.NEWLINE);
	}
}
