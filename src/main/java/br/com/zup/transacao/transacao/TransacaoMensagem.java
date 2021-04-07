package br.com.zup.transacao.transacao;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.Map;

class TransacaoMensagem {

    private String id;

    private BigDecimal valor;

    private Map<String, String> estabelecimento;

    private Map<String, String> cartao;

    TransacaoMensagem(String id, BigDecimal valor, Map<String, String> estabelecimento, Map<String, String> cartao) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

    Transacao paraTransacao(ObjectMapper mapper){
        Cartao entidadeCartao = mapper.convertValue(this.cartao, Cartao.class);
        Estabelecimento entidadeEstabelecimento = mapper.convertValue(this.estabelecimento, Estabelecimento.class);
        return new Transacao(this.id, this.valor, entidadeEstabelecimento, entidadeCartao);
    }

    @Deprecated
    TransacaoMensagem() {
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Map<String, String> getEstabelecimento() {
        return estabelecimento;
    }

    public Map<String, String> getCartao() {
        return cartao;
    }
}
