package br.com.zup.transacao.transacao;

import javax.persistence.Embeddable;
import java.util.StringJoiner;

@Embeddable
class Estabelecimento {

    private String nome;
    private String endereco;

    Estabelecimento(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    @Deprecated
    Estabelecimento() {
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }
}
