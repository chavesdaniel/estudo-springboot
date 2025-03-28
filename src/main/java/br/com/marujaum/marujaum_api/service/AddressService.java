package br.com.marujaum.marujaum_api.service;

import br.com.marujaum.marujaum_api.domain.address.Address;
import br.com.marujaum.marujaum_api.domain.event.Event;
import br.com.marujaum.marujaum_api.domain.event.EventRequestDTO;
import br.com.marujaum.marujaum_api.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(EventRequestDTO data, Event event) {
        Address address = new Address();
        address.setCity(data.city());
        address.setUf(data.state());
        address.setEvent(event);

        return addressRepository.save(address);
    }

    public Optional<Address> findByEventId(UUID eventId) {
        return addressRepository.findByEventId(eventId);
    }
}
