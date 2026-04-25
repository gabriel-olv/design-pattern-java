package br.com.gbrlo.learning.designpattern.infrastructure.external;

import br.com.gbrlo.learning.designpattern.infrastructure.external.model.ViaCepResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ViaCepClientTest {

    @Autowired
    private ViaCepClient viaCepClient;

    @Test
    void shouldGetANotNullViaCepResponse() {
        ViaCepResponse viaCepResponse = viaCepClient.findAddressBy("79816460");
        assertNotNull(viaCepResponse);
        assertEquals("Dourados", viaCepResponse.getLocalidade());
    }
}