package ru.denmehta.iikoService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "[order]")
public class Order extends BaseEntity{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false)
    private String id;

    @Column
    private Date completeBefore;

    @Column
    private String phone;

    @Column
    private String orderTypeId;

    @Column
    private String orderServiceType;

    @Column
    private String comment;

    @Column
    private String operatorId;

    @ManyToOne(targetEntity = Customer.class)
    @JsonIgnoreProperties("orders")
    @JoinColumn(name = "customerId")
    private Customer customer;




}
