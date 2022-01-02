package ru.denmehta.iikoService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denmehta.iikoService.models.Customer;
import ru.denmehta.iikoService.models.PinCode;
import ru.denmehta.iikoService.models.Site;

import java.util.Date;
import java.util.Optional;

public interface PinCodeRepository extends JpaRepository<PinCode, String> {
    Optional<PinCode> findByPhoneAndCode(String phone, String code);

    Optional<PinCode> findByExpiresInAfterAndPhone(Date now, String phone);

}
