package org.vadtel.sumservice.service;

public interface MapService {

    void add(String name, Integer value);

    void remove(String name);

    Integer sum(String first, String second);

}
