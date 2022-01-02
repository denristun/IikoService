package ru.denmehta.iikoService.service;

import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Customer;
import ru.denmehta.iikoService.models.Group;
import ru.denmehta.iikoService.models.PinCode;
import ru.denmehta.iikoService.models.Site;

@Service
public interface PinCodeServiceInterface {

    PinCode getByPhoneAndCode(String phone, String code);

    PinCode getNotExpiredCode(String phone);

    void save(PinCode pinCode);

    void delete(PinCode pinCode);



}
