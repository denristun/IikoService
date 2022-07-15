package ru.denmehta.iikoService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.denmehta.iikoService.models.Customer;
import ru.denmehta.iikoService.models.Product;
import ru.denmehta.iikoService.request.FavouriteProductRequestBody;
import ru.denmehta.iikoService.request.UpdateCustomerRequestBody;
import ru.denmehta.iikoService.response.RestApiException;
import ru.denmehta.iikoService.security.jwt.JwtTokenProvider;
import ru.denmehta.iikoService.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final SiteService siteService;
    private final ProductService productService;
    private final CustomerService customerService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public CustomerController(SiteService siteService, ProductService productService,
                              CustomerService customerService,
                              JwtTokenProvider jwtTokenProvider) {
        this.siteService = siteService;
        this.productService = productService;
        this.customerService = customerService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(
            HttpServletRequest request) {

        Customer customer = getCustomerFromRequest(request);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(path = "", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> updateBirthday(@RequestBody UpdateCustomerRequestBody updateCustomerRequestBody,
                                                   HttpServletRequest request) {


        Customer customer = getCustomerFromRequest(request);
        customer.setBirthday(updateCustomerRequestBody.getBirthday());
        customer.setName(updateCustomerRequestBody.getName());
        customer.setSurname(updateCustomerRequestBody.getSurname());
        customer.setMiddleName(updateCustomerRequestBody.getMiddleName());
        customer.setSex(updateCustomerRequestBody.getSex());
        customer.setEmail(updateCustomerRequestBody.getEmail());
        customerService.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    @RequestMapping(path = "/favourite", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> addFavouriteProduct(@RequestBody FavouriteProductRequestBody addFavouriteProductRequestBody,
                                                        HttpServletRequest request) {

        if (Objects.isNull(addFavouriteProductRequestBody.getProductId())) {
            throw new RestApiException(HttpStatus.BAD_REQUEST, "productId is required");
        }

        Customer customer = getCustomerFromRequest(request);
        Product product = productService.getById(addFavouriteProductRequestBody.getProductId());

        Set<Product> favouriteProducts = customer.getFavouriteProducts();
        favouriteProducts.add(product);
        customer.setFavouriteProducts(favouriteProducts);
        customerService.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    @RequestMapping(path = "/favourite", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> deleteFavouriteProduct(@RequestBody FavouriteProductRequestBody addFavouriteProductRequestBody,
                                                           HttpServletRequest request) {

        if (Objects.isNull(addFavouriteProductRequestBody.getProductId())) {
            throw new RestApiException(HttpStatus.BAD_REQUEST, "productId is required");
        }

        Customer customer = getCustomerFromRequest(request);
        Product product = productService.getById(addFavouriteProductRequestBody.getProductId());

        Set<Product> favouriteProducts = customer.getFavouriteProducts();
        favouriteProducts.remove(product);
        customer.setFavouriteProducts(favouriteProducts);
        customerService.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    private Customer getCustomerFromRequest(HttpServletRequest request) {
        String domain = jwtTokenProvider.getSite(request).getDomain();
        String phone = jwtTokenProvider.getPhone(request);
        return customerService.getByPhoneAndSite(phone, siteService.findByDomain(domain));


    }


}
