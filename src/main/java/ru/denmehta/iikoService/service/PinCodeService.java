package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.PinCode;
import ru.denmehta.iikoService.repository.PinCodeRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class PinCodeService {

    final PinCodeRepository pinCodeRepository;

    @Autowired
    public PinCodeService(PinCodeRepository pinCodeRepository) {
        this.pinCodeRepository = pinCodeRepository;
    }

    public PinCode getByPhoneAndCode(String phone, String code) {
        Optional<PinCode> optionalPinCode = pinCodeRepository.findByPhoneAndCode(phone, code);
        if (optionalPinCode.isPresent()) {
            return optionalPinCode.get();
        }
        return null;
    }

    public PinCode getNotExpiredCode(String phone) {
        Optional<PinCode> optionalPinCode = pinCodeRepository.findByExpiresInAfterAndPhone(new Date(), phone);
        if (optionalPinCode.isPresent()) {
            return optionalPinCode.get();
        }
        return null;
    }

    public void save(PinCode pinCode) {
        pinCodeRepository.save(pinCode);
    }
    public void delete(PinCode pinCode) {
    pinCodeRepository.delete(pinCode);
    }
}
