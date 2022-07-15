package ru.denmehta.iikoService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "[group]")
public class Group extends BaseEntity {

    @Id()
    @Column()
    private String id;

    @Column()
    private String name;

    @Column()
    private String additionalInfo;

    @Column()
    private String description;

    @Column()
    private boolean isDeleted;
    @Column()
    private String code;

    @Column()
    private String seoDescription;

    @Column()
    private String seoKeywords;

    @Column()
    private String seoText;

    @Column()
    private String seoTitle;

    @Column()
    private String images;

    @Column()
    private boolean isIncludedInMenu;

    @Column()
    private boolean isGroupModifier;

    @Column(name = "[order]")
    private Integer order;

    @Column()
    private Integer menuOrder;

    @Column()
    private boolean isSiteDisplay;

    @Column()
    private boolean isCombo;

    @Column()
    private boolean isService;

    @Column()
    private Integer comboProductsCount;

    @Column()
    private String imageLinks;

    @Column()
    private String parentGroup;

//    @OneToMany(mappedBy = "group", targetEntity = Product.class)
//    private Set<Product> products;

    @ManyToOne(targetEntity = Site.class)
    @JsonIgnoreProperties("groups")
    @JoinColumn(name = "siteId")
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

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public String getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

    public String getSeoText() {
        return seoText;
    }

    public void setSeoText(String seoText) {
        this.seoText = seoText;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public boolean isIncludedInMenu() {
        return isIncludedInMenu;
    }

    public void setIncludedInMenu(boolean includedInMenu) {
        isIncludedInMenu = includedInMenu;
    }

    public boolean isGroupModifier() {
        return isGroupModifier;
    }

    public void setGroupModifier(boolean groupModifier) {
        isGroupModifier = groupModifier;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public boolean isSiteDisplay() {
        return isSiteDisplay;
    }

    public void setSiteDisplay(boolean siteDisplay) {
        isSiteDisplay = siteDisplay;
    }

    public boolean isCombo() {
        return isCombo;
    }

    public void setCombo(boolean combo) {
        isCombo = combo;
    }

    public boolean isService() {
        return isService;
    }

    public void setService(boolean service) {
        isService = service;
    }

    public Integer getComboProductsCount() {
        return comboProductsCount;
    }

    public void setComboProductsCount(Integer comboProductsCount) {
        this.comboProductsCount = comboProductsCount;
    }

    public String getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(String imageLinks) {
        this.imageLinks = imageLinks;
    }

    public String getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(String parentGroup) {
        this.parentGroup = parentGroup;
    }

//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }
}
