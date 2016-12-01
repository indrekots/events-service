package com.mycompany.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.mycompany.api.Event;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

public class DummyEventRepository implements EventRepository {

    private static final String DATA_SOURCE = "dummy_data.json";

    private List<Event> events;

    public DummyEventRepository() {
        try {
            initData();
        } catch (IOException e) {
            throw new RuntimeException(DATA_SOURCE +
                    " is missing or is unreadable");
        }
    }

    private void initData() throws IOException {
        URL url = Resources.getResource(DATA_SOURCE);
        String json = Resources.toString(url, Charsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        CollectionType type = mapper.getTypeFactory()
                .constructCollectionType(List.class, Event.class);
        events = mapper.readValue(json, type);
    }

    @Override
    public List<Event> findAll() {
        return events;
    }

    @Override
    public Optional<Event> findById(Long id) {
        return events.stream().filter(e -> e.getId() == id).findFirst();
    }

}

