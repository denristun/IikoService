package ru.denmehta.iikoService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denmehta.iikoService.models.FavouriteProduct;

import java.util.Optional;

public interface FavouriteProductRepository extends JpaRepository<FavouriteProduct, String> {

}
