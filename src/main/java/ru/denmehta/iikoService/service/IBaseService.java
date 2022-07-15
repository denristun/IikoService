package ru.denmehta.iikoService.service;

import java.util.List;

public interface IBaseService<T, M> {

    List<T> findAll();

    void save(T data);

    void delete(M id);

}
