package br.com.zup.transacao.transacao;

import java.math.BigDecimal;

class TransacaoResposta {

    final private BigDecimal valor;
    final private Estabelecimento estabelecimento;

    TransacaoResposta(Transacao transacao) {
        this.valor = transacao.getValor();
        this.estabelecimento = transacao.getEstabelecimento();
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }
}
