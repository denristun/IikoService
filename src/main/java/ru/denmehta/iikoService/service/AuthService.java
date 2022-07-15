package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.PinCode;
import ru.denmehta.iikoService.util.Utils;

@Service
public class AuthService {
    final PinCodeService pinCodeService;

    @Autowired
    public AuthService(PinCodeService pinCodeService) {
        this.pinCodeService = pinCodeService;
    }

    public PinCode generatePinCode(String phone) {
        String code = Utils.generateCode(6);
        PinCode pinCode = new PinCode(phone, code);
        pinCodeService.save(pinCode);
        return pinCode;
    }

}
