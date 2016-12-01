package com.mycompany.core;

import com.mycompany.api.Event;

import java.util.List;
import java.util.Optional;

public interface EventRepository {

    List<Event> findAll();

    Optional<Event> findById(Long id);

    Event save(Event event);

}
