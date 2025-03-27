package br.com.marujaum.marujaum_api.repositories;

import br.com.marujaum.marujaum_api.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
