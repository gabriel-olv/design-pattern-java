package br.com.gbrlo.learning.designpattern.core.strategy;

import br.com.gbrlo.learning.designpattern.core.model.Address;

public interface AddressSearching {
    Address findAddressBy(String zipCode);
}
