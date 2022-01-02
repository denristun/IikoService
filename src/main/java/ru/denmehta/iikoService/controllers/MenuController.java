package ru.denmehta.iikoService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.denmehta.iikoService.models.Group;
import ru.denmehta.iikoService.models.Product;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.request.MenuRequestBody;
import ru.denmehta.iikoService.response.RestApiException;
import ru.denmehta.iikoService.service.GroupService;
import ru.denmehta.iikoService.service.ProductService;
import ru.denmehta.iikoService.service.SiteService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {

    private final ProductService productService;
    private final GroupService groupService;
    private final SiteService siteService;

    @Autowired
    public MenuController(ProductService productService, GroupService groupService, SiteService siteService) {
        this.productService = productService;
        this.groupService = groupService;
        this.siteService = siteService;
    }


    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProduct(@PathVariable("id") String productId) {
        if (productId == null) {
            throw new RestApiException(HttpStatus.BAD_REQUEST, "product id is required");
        }
        Product product = this.productService.getById(productId);
        if (Objects.isNull(product)) {
            throw new RestApiException(HttpStatus.NOT_FOUND, "product not found");
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @RequestMapping(path = "/groups", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Group>> getMenu(@RequestHeader("Origin") String domain) {

        Site site = siteService.findByDomain(domain);
        if(Objects.isNull(site)){
            throw new RestApiException(HttpStatus.UNAUTHORIZED, "not allowed from domain " + domain);
        }

        List<Group> groups = this.groupService.getAllSiteDisplayedAndSite(site);
        if (groups.isEmpty()) {
            throw new RestApiException(HttpStatus.NOT_FOUND, "groups not found");
        }
        return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
    }

}