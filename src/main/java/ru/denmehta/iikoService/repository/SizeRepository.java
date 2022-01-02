package ru.denmehta.iikoService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.models.Size;

import java.util.List;
import java.util.Optional;

public interface SizeRepository extends JpaRepository<Size, String> {


}
