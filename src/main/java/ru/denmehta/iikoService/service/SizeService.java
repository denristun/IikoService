package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Size;
import ru.denmehta.iikoService.repository.SizeRepository;

@Service
public class SizeService implements  SizeServiceInterface{


    final SizeRepository sizeRepository;

    @Autowired
    public SizeService(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    @Override
    public void save(Size size) {
    this.sizeRepository.save(size);
    }

    @Override
    public void delete(String id) {

    }
}
