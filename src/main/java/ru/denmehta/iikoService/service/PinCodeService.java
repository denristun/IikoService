package ru.denmehta.iikoService.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.PinCode;
import ru.denmehta.iikoService.repository.PinCodeRepository;

import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
public class PinCodeService implements PinCodeServiceInterface{

    final PinCodeRepository pinCodeRepository;

    @Autowired
    public PinCodeService(PinCodeRepository pinCodeRepository) {
        this.pinCodeRepository = pinCodeRepository;
    }

    @Override
    public PinCode getByPhoneAndCode(String phone, String code) {
        Optional<PinCode> optionalPinCode = pinCodeRepository.findByPhoneAndCode(phone, code);
        if (optionalPinCode.isPresent()) {
            return optionalPinCode.get();
        }
        return null;
    }

    @Override
    public PinCode getNotExpiredCode(String phone) {
        Optional<PinCode> optionalPinCode = pinCodeRepository.findByExpiresInAfterAndPhone(new Date(), phone);
        if (optionalPinCode.isPresent()) {
            return optionalPinCode.get();
        }
        return null;
    }

    @Override
    public void save(PinCode pinCode) {
        pinCodeRepository.save(pinCode);
    }
    @Override
    public void delete(PinCode pinCode) {
    pinCodeRepository.delete(pinCode);
    }
}
