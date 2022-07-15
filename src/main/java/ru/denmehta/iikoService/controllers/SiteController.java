package ru.denmehta.iikoService.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.denmehta.iikoService.models.Product;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.request.MenuRequestBody;
import ru.denmehta.iikoService.request.SiteRequestBody;
import ru.denmehta.iikoService.response.RestApiException;
import ru.denmehta.iikoService.service.SiteService;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/site")
public class SiteController {

    private final SiteService siteService;

    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }


    @RequestMapping(value = "", method = RequestMethod.GET,
          produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Site>> getSites(@RequestHeader("Origin") String domain) {
        List<Site> sites = siteService.getAll();
        return new ResponseEntity<>(sites, HttpStatus.OK);

    }

    @RequestMapping(value = "", method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteSite(@RequestBody SiteRequestBody siteRequestBody,
                                                 @RequestHeader("Origin") String domain) {
        String siteId = siteRequestBody.getSiteId();

        if (Objects.isNull(siteId)) {
            throw new RestApiException(HttpStatus.BAD_REQUEST, "siteId is required");
        }

        siteService.deleteById(siteId);
        return new ResponseEntity<>(siteId, HttpStatus.OK);

    }

    @RequestMapping(value = "", method = RequestMethod.PATCH,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Site> updateSite(@RequestBody SiteRequestBody siteRequestBody,
                                                 @RequestHeader("Origin") String domain) {

        String siteId = siteRequestBody.getSiteId();

        if (Objects.isNull(siteId)) {
            throw new RestApiException(HttpStatus.BAD_REQUEST, "siteId is required");
        }

        Site site = this.siteService.getById(siteId);
        if (Objects.isNull(site)) {
            throw new RestApiException(HttpStatus.NOT_FOUND, "site not found");
        }
        site.setActive(siteRequestBody.isActive());
        site.setApiLogin(siteRequestBody.getApiLogin());
        site.setDomain(siteRequestBody.getDomain());
        site.setToken(siteRequestBody.getToken());
        this.siteService.save(site);

        return new ResponseEntity<>(site, HttpStatus.OK);

    }

    @RequestMapping(value = "", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Site> addSite(@RequestBody SiteRequestBody siteRequestBody,
                                              @RequestHeader("Origin") String domain) {

        Site site = new Site();
        site.setActive(siteRequestBody.isActive());
        site.setApiLogin(siteRequestBody.getApiLogin());
        site.setDomain(siteRequestBody.getDomain());
        site.setToken(siteRequestBody.getToken());
        this.siteService.save(site);

        return new ResponseEntity<>(site, HttpStatus.OK);

    }


}
