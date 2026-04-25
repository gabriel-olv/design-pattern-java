package br.com.gbrlo.learning.designpattern.core.service;

import br.com.gbrlo.learning.designpattern.core.model.Client;
import br.com.gbrlo.learning.designpattern.core.strategy.AddressSearchStrategy;
import br.com.gbrlo.learning.designpattern.infrastructure.repository.AddressRepository;
import br.com.gbrlo.learning.designpattern.infrastructure.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private Map<String, AddressSearchStrategy> addressSearchStrategies = new HashMap<>();

    @Transactional
    public Client createClient(String name, String zipCode) {
        var client = new Client();
        client.setName(name);

        boolean alreadyExistsAddress = addressRepository.existsByZipCode(zipCode);
        if (alreadyExistsAddress) {
            var address = addressSearchStrategies.get("addressLocalDatabaseSearchStrategy").findAddressBy(zipCode);
            client.setAddress(address);
        } else {
            var address = addressSearchStrategies.get("addressViaCepSearchStrategy").findAddressBy(zipCode);
            client.setAddress(address);
        }
        return clientRepository.save(client);
    }

    @Transactional(readOnly = true)
    public Page<Client> findAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }
}
