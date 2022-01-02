package ru.denmehta.iikoService.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "pinCode")
@Getter
@Setter
@ToString
public class PinCode extends BaseEntity {

    public PinCode(String phone, String code) {
        this.phone = phone;
        this.code = code;
        this.expiresIn = new Date(new Date().getTime() + 60000) ;
    }

    @Id()
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column()
    private String phone;

    @Column()
    private String code;

    @Column()
    private Date expiresIn;

    public PinCode() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Date expiresIn) {
        this.expiresIn = expiresIn;
    }
}
