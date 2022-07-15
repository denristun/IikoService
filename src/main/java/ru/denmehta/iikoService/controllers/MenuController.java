package ru.denmehta.iikoService.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.denmehta.iikoService.models.Group;
import ru.denmehta.iikoService.models.Product;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.request.AuthRequestBody;
import ru.denmehta.iikoService.request.MenuRequestBody;
import ru.denmehta.iikoService.response.RestApiException;
import ru.denmehta.iikoService.service.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/menu")
public class MenuController {

    private final ProductService productService;
    private final GroupService groupService;
    private final SiteService siteService;

    public MenuController(ProductService productService, GroupService groupService, SiteService siteService) {
        this.productService = productService;
        this.groupService = groupService;
        this.siteService = siteService;
    }


    @RequestMapping(value = "/product", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@RequestBody MenuRequestBody menuRequestBody,
                                              @RequestHeader("Origin") String domain) {

        String productId = menuRequestBody.getProductId();

        if (Objects.isNull(productId)) {
            throw new RestApiException(HttpStatus.BAD_REQUEST, "product id is required");
        }

        Product product = this.productService.getById(productId);
        if (Objects.isNull(product)) {
            throw new RestApiException(HttpStatus.NOT_FOUND, "product not found");
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Product>> getAllProductsBySiteToken(@RequestBody MenuRequestBody menuRequestBody,
                                                                   @RequestHeader("Origin") String domain) {

        Site site = getSite(menuRequestBody, domain);
        String groupId = menuRequestBody.getGroupId();

        List<Product> products = this.productService.getAllBySite(site)
                .stream()
                .filter(product -> {
                    return !Objects.nonNull(groupId) || product.getGroup().equals(groupId);
                }).collect(Collectors.toList());
        if (Objects.isNull(products)) {
            throw new RestApiException(HttpStatus.NOT_FOUND, "products not found");
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @RequestMapping(path = "/groups", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Group>> getMenu(@RequestBody MenuRequestBody menuRequestBody,
                                               @RequestHeader("Origin") String domain) {

        Site site = getSite(menuRequestBody, domain);

        List<Group> groups = this.groupService.getAllSiteDisplayedAndSite(site);
        if (groups.isEmpty()) {
            throw new RestApiException(HttpStatus.NOT_FOUND, "groups not found");
        }
        return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
    }

    private Site getSite(MenuRequestBody menuRequestBody, String domain) {
        String token = menuRequestBody.getToken();
        Site site = Objects.isNull(token) ? siteService.findByDomain(domain) : siteService.findByToken(token);
        if (Objects.isNull(site)) {
            throw new RestApiException(HttpStatus.UNAUTHORIZED, "not allowed from domain " + domain);
        }
        return site;
    }

}