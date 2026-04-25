package br.com.gbrlo.learning.designpattern.infrastructure.external.mapper;

import br.com.gbrlo.learning.designpattern.core.model.Address;
import br.com.gbrlo.learning.designpattern.infrastructure.external.model.ViaCepResponse;

public class ViaCepResponseMapper {

    public static Address toAddress(ViaCepResponse viaCepResponse) {
        Address address = new Address();
        address.setZipCode(viaCepResponse.getCep());
        address.setStreet(viaCepResponse.getLogradouro());
        address.setNeighborhood(viaCepResponse.getBairro());
        address.setCity(viaCepResponse.getLocalidade());
        address.setComplement(viaCepResponse.getComplemento());
        address.setUf(viaCepResponse.getUf());
        address.setState(viaCepResponse.getEstado());
        address.setIbgeCode(viaCepResponse.getIbge());
        return address;
    }
}
