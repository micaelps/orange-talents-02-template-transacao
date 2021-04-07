package br.com.zup.transacao.transacao;

import javax.persistence.*;
import java.util.StringJoiner;

@Embeddable
class Cartao {

    private String id;
    private String email;


    Cartao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    @Deprecated
    Cartao() {
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}
