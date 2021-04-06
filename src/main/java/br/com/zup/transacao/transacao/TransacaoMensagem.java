package br.com.zup.transacao.transacao;

import java.math.BigDecimal;
import java.util.Map;
import java.util.StringJoiner;

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

    @Override
    public String toString() {
        return new StringJoiner(", ", TransacaoMensagem.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("valor=" + valor)
                .add("estabelecimento=" + estabelecimento)
                .add("cartao=" + cartao)
                .toString();
    }
}
