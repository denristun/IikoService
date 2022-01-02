package ru.denmehta.iikoService.service;

import ru.denmehta.iikoService.models.Product;

import java.util.List;

public interface ProductServiceInterface {
    Product getById(String id);

    void save(Product product);

    void delete(String id);

    List<Product> getAll();
}
