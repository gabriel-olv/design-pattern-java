package br.com.gbrlo.learning.designpattern.infrastructure.repository;

import br.com.gbrlo.learning.designpattern.core.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findByZipCode(String zipCode);
}
