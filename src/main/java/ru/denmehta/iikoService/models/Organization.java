package ru.denmehta.iikoService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "organization")
public class Organization extends  BaseEntity{
    @Id()
    private String id;

    @Column()
    private String name;
    @Column()
    private String country;
    @Column()
    private String restaurantAddress;
    @Column()
    private Boolean useUaeAddressingSystem;
    @Column(updatable = false)
    private String city;
    @Column(updatable = false)
    private String deliveryPhones;
    @Column(updatable = false)
    private String restaurantPhones;
    @Column(updatable = false)
    private String area;
    @Column(updatable = false)
    private String email;
    @Column(updatable = false)
    private Boolean iiko;
    @Column(updatable = false)
    private String workTime;
    @Column(updatable = false)
    private String additionalInfo;

    @OneToMany(mappedBy="organization", targetEntity = Terminal.class)
    private Set<Terminal> terminals;

    @ManyToOne(targetEntity = Site.class)
    @JsonIgnoreProperties("organizations")
    @JoinColumn(name="siteId", updatable = false)
    private Site site;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public Boolean getUseUaeAddressingSystem() {
        return useUaeAddressingSystem;
    }

    public void setUseUaeAddressingSystem(Boolean useUaeAddressingSystem) {
        this.useUaeAddressingSystem = useUaeAddressingSystem;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDeliveryPhones() {
        return deliveryPhones;
    }

    public void setDeliveryPhones(String deliveryPhones) {
        this.deliveryPhones = deliveryPhones;
    }

    public String getRestaurantPhones() {
        return restaurantPhones;
    }

    public void setRestaurantPhones(String restaurantPhones) {
        this.restaurantPhones = restaurantPhones;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIiko() {
        return iiko;
    }

    public void setIiko(Boolean iiko) {
        this.iiko = iiko;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Set<Terminal> getTerminals() {
        return terminals;
    }

    public void setTerminals(Set<Terminal> terminals) {
        this.terminals = terminals;
    }

    public Site getSite() {
        return site;
    }

}
