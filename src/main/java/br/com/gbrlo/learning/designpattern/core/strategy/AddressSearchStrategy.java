package br.com.gbrlo.learning.designpattern.core.strategy;

import br.com.gbrlo.learning.designpattern.core.model.Address;

public interface AddressSearchStrategy {
    Address findAddressBy(String zipCode);
}
