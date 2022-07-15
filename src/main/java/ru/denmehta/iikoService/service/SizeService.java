package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Size;
import ru.denmehta.iikoService.repository.SizeRepository;

@Service
public class SizeService implements IBaseDbService<Size, String> {


    final SizeRepository sizeRepository;

    @Autowired
    public SizeService(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }


    @Override
    public String getName() {
        return Size.class.getName();
    }

    @Override
    public JpaRepository<Size, String> getRepository() {
        return sizeRepository;
    }
}
