package br.com.gbrlo.learning.designpattern.infrastructure.repository;

import br.com.gbrlo.learning.designpattern.core.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
