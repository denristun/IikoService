package ru.denmehta.iikoService.service;

import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Product;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.repository.ProductRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService  {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getById(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        return null;
    }

    public void save(Product product) {
    }

    public void delete(String id) {

    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }


    public List<Product> getAllBySite(Site site) {
        return productRepository.findAllProductsBySiteToken(site.getToken());

    }

}
