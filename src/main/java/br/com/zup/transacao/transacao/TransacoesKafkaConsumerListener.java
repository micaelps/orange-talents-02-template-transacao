package br.com.zup.transacao.transacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class TransacoesKafkaConsumerListener {

    final Logger logger = LoggerFactory.getLogger(TransacoesKafkaConsumerListener.class.getName());

    @KafkaListener(topics = "${kafka.topic.name}")
    void consume(TransacaoMensagem transacao) {
        logger.info(transacao.toString());
    }
}
