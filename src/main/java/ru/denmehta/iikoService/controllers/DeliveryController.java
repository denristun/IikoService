package ru.denmehta.iikoService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.denmehta.iikoService.models.Organization;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.models.Terminal;
import ru.denmehta.iikoService.request.DeliveryRequestBody;
import ru.denmehta.iikoService.response.RestApiException;
import ru.denmehta.iikoService.service.OrganizationService;
import ru.denmehta.iikoService.service.SiteService;
import ru.denmehta.iikoService.service.TerminalService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/delivery")
public class DeliveryController {

    private final SiteService siteService;
    private final OrganizationService organizationService;
    private final TerminalService terminalService;

    @Autowired
    public DeliveryController(SiteService siteService, OrganizationService organizationService, TerminalService terminalService) {
        this.siteService = siteService;
        this.organizationService = organizationService;
        this.terminalService = terminalService;
    }

    @RequestMapping(path = "/terminals", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Terminal>> getTerminals(@RequestBody DeliveryRequestBody deliveryRequestBody,
                                                       @RequestHeader("Origin") String domain) {

        Site site = siteService.findByDomain(domain);
        if (Objects.isNull(site)) {
            throw new RestApiException(HttpStatus.UNAUTHORIZED, "not allowed from domain " + domain);
        }

        Organization organization = this.organizationService.getById(deliveryRequestBody.getOrganizationId());

        if (Objects.isNull(organization)) {
            throw new RestApiException(HttpStatus.NOT_FOUND, "organization not found");
        }
        List<Terminal> terminals = this.terminalService.findByOrganization(organization);

        if (terminals.isEmpty()) {
            throw new RestApiException(HttpStatus.NOT_FOUND, "terminals not found");
        }
        return new ResponseEntity<List<Terminal>>(terminals, HttpStatus.OK);
    }

}