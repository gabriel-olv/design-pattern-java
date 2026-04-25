package br.com.gbrlo.learning.designpattern.core.service;

import br.com.gbrlo.learning.designpattern.core.model.Address;
import br.com.gbrlo.learning.designpattern.core.model.Client;
import br.com.gbrlo.learning.designpattern.infrastructure.repository.AddressRepository;
import br.com.gbrlo.learning.designpattern.infrastructure.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Test
    void shouldCreateAClientAndYourAddress() {
        Client client = clientService.createClient("Davi Carlos Eduardo Martins", "79816-460");
        assertNotNull(client);
        assertTrue(client.getName().startsWith("Davi"));

        Address address = client.getAddress();
        assertNotNull(address);
        assertEquals("79816460", address.getZipCode());
    }
}