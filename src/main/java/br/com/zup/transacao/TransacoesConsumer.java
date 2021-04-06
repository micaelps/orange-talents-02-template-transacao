package br.com.zup.transacao;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;

@Component
class TransacoesKafkaConsumerListener {

    private final Logger logger = LoggerFactory.getLogger(TransacoesKafkaConsumerListener.class.getName());

    @KafkaListener(topics = "${kafka.topic.name}")
    public void consume(Transacao transacao) {
        logger.info(transacao.toString());
    }
}
