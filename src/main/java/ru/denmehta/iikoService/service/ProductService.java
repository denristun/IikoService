package ru.denmehta.iikoService.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Product;
import ru.denmehta.iikoService.repository.ProductRepository;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    ProductRepository productRepository;


    @Override
    public Product getById(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        return null;
    }

    @Override
    public void save(Product product) {
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
