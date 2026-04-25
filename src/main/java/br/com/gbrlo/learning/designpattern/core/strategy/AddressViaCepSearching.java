package br.com.gbrlo.learning.designpattern.core.strategy;

import br.com.gbrlo.learning.designpattern.core.model.Address;
import br.com.gbrlo.learning.designpattern.infrastructure.external.ViaCepClient;
import br.com.gbrlo.learning.designpattern.infrastructure.external.model.ViaCepResponse;
import br.com.gbrlo.learning.designpattern.infrastructure.external.mapper.ViaCepResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressViaCepSearching implements AddressSearching {

    @Autowired
    private ViaCepClient viaCepClient;

    @Override
    public Address findAddressBy(String zipCode) {
        ViaCepResponse viaCepResponse = viaCepClient.findAddressBy(zipCode);
        return ViaCepResponseMapper.toAddress(viaCepResponse);
    }
}
