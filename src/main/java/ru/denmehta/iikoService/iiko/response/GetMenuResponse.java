package ru.denmehta.iikoService.iiko.response;

import ru.denmehta.iikoService.iiko.classes.ProductCategory;
import ru.denmehta.iikoService.models.Size;
import ru.denmehta.iikoService.models.Group;
import ru.denmehta.iikoService.models.Product;

import java.util.List;

public class GetMenuResponse extends IikoBaseResponse {

    private List<Group> groups;

    private List<ProductCategory> productCategories;

    private List<Product> products;

    private List<Size> sizes;

    private String revision;

    public List<Group> getGroups() {
        return groups;
    }

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public String getRevision() {
        return revision;
    }
}
