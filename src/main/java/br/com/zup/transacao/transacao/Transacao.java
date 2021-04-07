package br.com.zup.transacao.transacao;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String idExternoTransacao;

    @Column(nullable = false)
    private BigDecimal valor;

    @Embedded
    @Column(nullable = false)
    private Estabelecimento estabelecimento;

    @AttributeOverrides({@AttributeOverride(name="id", column=@Column(name="cartao_id"))})
    private Cartao cartao;

    Transacao(String idExternoTransacao, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao) {
        this.idExternoTransacao = idExternoTransacao;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

    Transacao() {
    }


    public String getIdExternoTransacao() {
        return idExternoTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }
}
