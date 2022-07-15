package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.PinCode;
import ru.denmehta.iikoService.repository.PinCodeRepository;
import ru.denmehta.iikoService.response.RestApiException;

import java.util.Date;
import java.util.Optional;

@Service
public class PinCodeService implements IBaseDbService<PinCode, String> {

    final PinCodeRepository pinCodeRepository;

    @Autowired
    public PinCodeService(PinCodeRepository pinCodeRepository) {
        this.pinCodeRepository = pinCodeRepository;
    }

    public PinCode getByPhoneAndCode(String phone, String code) {
       return pinCodeRepository.findByPhoneAndCode(phone, code).orElseThrow(() -> new RestApiException(HttpStatus.UNAUTHORIZED, "wrong code or phone"));
    }

    public Optional<PinCode> getNotExpiredCode(String phone) {
        return pinCodeRepository.findByExpiresInAfterAndPhone(new Date(), phone);
    }

    @Override
    public String getName() {
        return PinCode.class.getName();
    }

    @Override
    public JpaRepository<PinCode, String> getRepository() {
        return pinCodeRepository;
    }
}
