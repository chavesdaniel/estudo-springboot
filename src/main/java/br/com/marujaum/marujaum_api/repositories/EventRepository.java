package br.com.marujaum.marujaum_api.repositories;

import br.com.marujaum.marujaum_api.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}
