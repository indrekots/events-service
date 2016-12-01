package com.mycompany.core;

import com.mycompany.api.Event;

import java.util.List;

public interface EventRepository {

    List<Event> findAll();

}
