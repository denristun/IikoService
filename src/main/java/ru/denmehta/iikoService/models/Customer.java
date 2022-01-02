package ru.denmehta.iikoService.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity{

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
    private String email;

    @Column()
    private String referrerId;

    @Column()
    private Double bonus;

    @Column()
    private String name;

    @Column()
    private String surname;

    @Column()
    private String middleName;

    @Column()
    private String comment;

    @Column()
    private String cultureName;

    @Column()
    private Date birthday;

    @Column()
    private Integer sex;

    @Column()
    private Integer consentStatus;

    @Column()
    private Boolean anonymized;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "customerSite",
            joinColumns = { @JoinColumn(name = "customerId") },
            inverseJoinColumns = { @JoinColumn(name = "siteId") }
    )
    Set<Site> sites = new HashSet<>();

    @OneToMany(mappedBy = "customer", targetEntity = Order.class)
    private Set<Order> orders;


    @OneToMany(mappedBy="customer", targetEntity = FavouriteProduct.class)
    private Set<FavouriteProduct> favouriteProducts;


    //    @OneToMany((type) => Address, (address) => address.customer)
//    addresses: Address[]

//    @OneToMany((type) => WalletBalance, (walletBalance) => walletBalance.customer)
//    walletBalances: WalletBalance[]

//    @OneToMany((type) => Card, (card) => card.customer)
//    cards: Card[]

//    @OneToMany((type) => FavoriteProduct, (favoriteProduct) => favoriteProduct.customer, {
//            cascade: ['insert', 'update'],
//            })
//    favoriteProducts: FavoriteProduct[]


    public Set<FavouriteProduct> getFavouriteProducts() {
        return favouriteProducts;
    }

    public void setFavouriteProducts(Set<FavouriteProduct> favouriteProducts) {
        this.favouriteProducts = favouriteProducts;
    }

    public Set<Order> getOrders() {
        return orders;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReferrerId() {
        return referrerId;
    }

    public void setReferrerId(String referrerId) {
        this.referrerId = referrerId;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCultureName() {
        return cultureName;
    }

    public void setCultureName(String cultureName) {
        this.cultureName = cultureName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getConsentStatus() {
        return consentStatus;
    }

    public void setConsentStatus(Integer consentStatus) {
        this.consentStatus = consentStatus;
    }

    public Boolean getAnonymized() {
        return anonymized;
    }

    public void setAnonymized(Boolean anonymized) {
        this.anonymized = anonymized;
    }


    public void setSites(Set<Site> sites) {
        this.sites = sites;
    }
}
