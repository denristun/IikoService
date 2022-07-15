package ru.denmehta.iikoService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "sizePrice")
public class SizePrice extends BaseEntity{

    @Id
    private String sizeId;

    @ManyToOne(targetEntity = Price.class)
    @JoinColumn(name="priceId")
    private Price price;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name="productId")
    private Product product;



}
