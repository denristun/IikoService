package ru.denmehta.iikoService.service;

import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.models.Size;

import java.util.List;

public interface SizeServiceInterface {


    void save(Size size);

    void delete(String id);


}
