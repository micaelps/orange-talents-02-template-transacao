package br.com.zup.transacao.transacao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

interface TodasTransacoes extends JpaRepository<Transacao, Long> {

    Collection<Transacao> findTop10ByCartaoId(String idCartao);
    Optional<Transacao> findTopByCartaoId(String idCartao);

}
