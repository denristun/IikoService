package ru.denmehta.iikoService.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product")

public class Product extends BaseEntity {
    @Id
    @Column(nullable = false)
    private String id;

    @Column()
    private String name;

    @Column()
    private double price;

    @Column()
    private String code;

    @Column()
    private String description;

    @Column()
    private String seoDescription;

    @Column()
    private String seoKeywords;

    @Column()
    private String additionalInfo;

    @Column()
    private String seoText;

    @Column()
    private String seoTitle;

    @Column()
    private String fullNameEnglish;

    @Column()
    private String[] imageLinks;

    @Column()
    private boolean isDeleted;

    @Column()
    private String image;

    @Column()
    private String ingredients;

    @Column()
    private double weight;

    @Column()
    private Integer fatAmount;

    @Column()
    private Integer proteinsAmount;

    @Column()
    private Integer carbohydratesAmount;

    @Column()
    private Integer energyAmount;

    @Column()
    private Integer fatFullAmount;

    @Column()
    private Integer proteinsFullAmount;

    @Column()
    private Integer carbohydratesFullAmount;

    @Column()
    private Integer energyFullAmount;

    @Column()
    private String groupId;

    @Column()
    private String type;

    @Column()
    private String productCategoryId;

    @Column(name = "[order]")
    private Integer order;

    @Column()
    private String orderItemType;

    @Column()
    private String modifierSchemaName;

    @Column()
    private boolean doNotPrintInCheque;

    @Column()
    private String measureUnit;

    @Column()
    private boolean useBalanceForSell;

    @Column()
    private boolean canSetOpenPrice;


    @Column()
    private Date createdAt;

    @ManyToOne(targetEntity = Group.class)
    @JsonIgnoreProperties("products")
    @JoinColumn(name = "parentGroupId")
    private Group group;

    @OneToOne(mappedBy = "product")
    private FavouriteProduct favouriteProduct;


    @OneToMany(mappedBy = "product", targetEntity = SizePrice.class)
    private Set<SizePrice> sizePrices;

    public String[] getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(String[] imageLinks) {
        this.imageLinks = imageLinks;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getFullNameEnglish() {
        return fullNameEnglish;
    }

    public void setFullNameEnglish(String fullNameEnglish) {
        this.fullNameEnglish = fullNameEnglish;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getFatAmount() {
        return fatAmount;
    }

    public void setFatAmount(Integer fatAmount) {
        this.fatAmount = fatAmount;
    }

    public double getProteinsAmount() {
        return proteinsAmount;
    }

    public void setProteinsAmount(Integer proteinsAmount) {
        this.proteinsAmount = proteinsAmount;
    }

    public double getCarbohydratesAmount() {
        return carbohydratesAmount;
    }

    public void setCarbohydratesAmount(Integer carbohydratesAmount) {
        this.carbohydratesAmount = carbohydratesAmount;
    }

    public double getEnergyAmount() {
        return energyAmount;
    }

    public void setEnergyAmount(Integer energyAmount) {
        this.energyAmount = energyAmount;
    }

    public double getFatFullAmount() {
        return fatFullAmount;
    }

    public void setFatFullAmount(Integer fatFullAmount) {
        this.fatFullAmount = fatFullAmount;
    }

    public double getProteinsFullAmount() {
        return proteinsFullAmount;
    }

    public void setProteinsFullAmount(Integer proteinsFullAmount) {
        this.proteinsFullAmount = proteinsFullAmount;
    }

    public double getCarbohydratesFullAmount() {
        return carbohydratesFullAmount;
    }

    public void setCarbohydratesFullAmount(Integer carbohydratesFullAmount) {
        this.carbohydratesFullAmount = carbohydratesFullAmount;
    }

    public double getEnergyFullAmount() {
        return energyFullAmount;
    }

    public void setEnergyFullAmount(Integer energyFullAmount) {
        this.energyFullAmount = energyFullAmount;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public double getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getOrderItemType() {
        return orderItemType;
    }

    public void setOrderItemType(String orderItemType) {
        this.orderItemType = orderItemType;
    }

    public String getModifierSchemaName() {
        return modifierSchemaName;
    }

    public void setModifierSchemaName(String modifierSchemaName) {
        this.modifierSchemaName = modifierSchemaName;
    }

    public boolean isDoNotPrintInCheque() {
        return doNotPrintInCheque;
    }

    public void setDoNotPrintInCheque(boolean doNotPrintInCheque) {
        this.doNotPrintInCheque = doNotPrintInCheque;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public boolean isUseBalanceForSell() {
        return useBalanceForSell;
    }

    public void setUseBalanceForSell(boolean useBalanceForSell) {
        this.useBalanceForSell = useBalanceForSell;
    }

    public boolean isCanSetOpenPrice() {
        return canSetOpenPrice;
    }

    public void setCanSetOpenPrice(boolean canSetOpenPrice) {
        this.canSetOpenPrice = canSetOpenPrice;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getGroup() {
        return Objects.nonNull(group) ? group.getId() : null;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<SizePrice> getSizePrices() {
        return sizePrices;
    }

}
