package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Size;
import ru.denmehta.iikoService.repository.SizeRepository;

@Service
public class SizeService {


    final SizeRepository sizeRepository;

    @Autowired
    public SizeService(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    public void save(Size size) {
    this.sizeRepository.save(size);
    }

    public void delete(String id) {

    }
}
