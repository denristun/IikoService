package ru.denmehta.iikoService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.denmehta.iikoService.models.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query(value = "select * from `product` where `parentGroupId` in " +
            "(select g.id from `group` g join `site` s on g.siteId = s.id where s.token = ?1 )",
            nativeQuery = true)
    List<Product> findAllProductsBySiteToken(String token);
}