package ru.denmehta.iikoService.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Product;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.repository.ProductRepository;

import java.util.List;


@Service
public class ProductService implements IBaseDbService<Product, String> {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String getName() {
        return Product.class.getName();
    }

    @Override
    public JpaRepository<Product, String> getRepository() {
        return productRepository;
    }

    public List<Product> getAllBySite(Site site) {
        return productRepository.findAllProductsBySiteToken(site.getToken());

    }

}
