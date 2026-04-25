package br.com.gbrlo.learning.designpattern.core.strategy;

import br.com.gbrlo.learning.designpattern.core.model.Address;
import br.com.gbrlo.learning.designpattern.infrastructure.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressLocalDatabaseSearching implements AddressSearching {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address findAddressBy(String zipCode) {
        return addressRepository.findByZipCode(zipCode);
    }
}
