package br.com.gbrlo.learning.designpattern.infrastructure.config;

import br.com.gbrlo.learning.designpattern.infrastructure.external.ViaCepClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClientConfig {

    @Bean
    ViaCepClient viaCepClient(RestClient.Builder builder) {
        RestClient restClient = builder.baseUrl("https://viacep.com.br/ws").build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory.builderFor(adapter).build();
        return proxyFactory.createClient(ViaCepClient.class);
    }
}
