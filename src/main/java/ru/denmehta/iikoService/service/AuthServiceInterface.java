package ru.denmehta.iikoService.service;

import ru.denmehta.iikoService.models.PinCode;


public interface AuthServiceInterface {

    PinCode generatePinCode(String phone) ;

    boolean checkPinCode(String phone, String code);
}
