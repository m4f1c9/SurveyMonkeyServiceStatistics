package org.jugru.monkeyStatistics.service;

import java.util.List;

public interface Service<T> {

    T save(T t);

    T get(long id);

    void delete(T t);

    List<T> getAll();
}
