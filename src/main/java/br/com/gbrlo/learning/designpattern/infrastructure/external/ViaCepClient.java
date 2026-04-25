package br.com.gbrlo.learning.designpattern.infrastructure.external;

import br.com.gbrlo.learning.designpattern.infrastructure.external.model.ViaCepResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface ViaCepClient {

    @GetExchange("/{cep}/json")
    ViaCepResponse findAddressBy(@PathVariable String cep);
}
