package br.com.zup.transacao.transacao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
class TransacaoController {

    final TodasTransacoes todasTransacoes;

    TransacaoController(TodasTransacoes todasTransacoes) {
        this.todasTransacoes = todasTransacoes;
    }

    @GetMapping("/api/transacoes/{idCartao}")
    ResponseEntity<?> obterDezUltimasTransacoes(@PathVariable String idCartao){
        return todasTransacoes.findTopByCartaoId(idCartao)
                       .map(t -> todasTransacoes.findTop10ByCartaoId(idCartao))
                       .map(ts -> ts.stream().map(TransacaoResposta::new).collect(Collectors.toList()))
                       .map(trs -> ResponseEntity.ok(trs))
                       .orElseGet(()-> ResponseEntity.notFound().build());
    }

}
