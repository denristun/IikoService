package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.PinCode;
import ru.denmehta.iikoService.util.Utils;

import java.util.Objects;

@Service
public class   AuthService {
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

    public boolean checkPinCode(String phone, String code) {
      PinCode pinCode = pinCodeService.getByPhoneAndCode(phone, code);
      if(Objects.isNull(pinCode)){
          return false;
      }
      pinCodeService.delete(pinCode);
      return true;
    }
}
