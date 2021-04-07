package br.com.zup.transacao.transacao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
class TransacaoKafkaConsumerListener {

    final ObjectMapper mapper;
    final TodasTransacoes todasTransacoes;
    final Logger logger = LoggerFactory.getLogger(TransacaoKafkaConsumerListener.class.getName());

    TransacaoKafkaConsumerListener(ObjectMapper mapper, TodasTransacoes todasTransacoes) {
        this.mapper = mapper;
        this.todasTransacoes = todasTransacoes;
    }

    @KafkaListener(topics = "${kafka.topic.name}")
    @Transactional
    void consume(TransacaoMensagem mensagem) {
        Transacao transacao = mensagem.paraTransacao(mapper);
        todasTransacoes.save(transacao);
        logger.info("salvando transacao...");
    }
}
