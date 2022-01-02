package ru.denmehta.iikoService.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.PinCode;
import ru.denmehta.iikoService.repository.SiteRepository;
import ru.denmehta.iikoService.util.Utils;

import java.util.Objects;

@Slf4j
@Service
public class AuthService implements  AuthServiceInterface{
    final PinCodeService pinCodeService;

    @Autowired
    public AuthService(PinCodeService pinCodeService) {
        this.pinCodeService = pinCodeService;
    }

    @Override
    public PinCode generatePinCode(String phone) {
        String code = Utils.generateCode(6);
        PinCode pinCode = new PinCode(phone, code);
        pinCodeService.save(pinCode);
        return pinCode;
    }

    @Override
    public boolean checkPinCode(String phone, String code) {
      PinCode pinCode = pinCodeService.getByPhoneAndCode(phone, code);
      if(Objects.isNull(pinCode)){
          return false;
      }
      pinCodeService.delete(pinCode);
      return true;
    }
}
