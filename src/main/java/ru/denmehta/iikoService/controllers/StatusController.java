package ru.denmehta.iikoService.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.denmehta.iikoService.enums.ServerState;
import ru.denmehta.iikoService.models.ServerStatus;
import ru.denmehta.iikoService.service.OrganizationService;
import ru.denmehta.iikoService.service.TerminalService;
import ru.denmehta.iikoService.service.TokenManagementService;

@RestController
@RequestMapping("/api/v1/status")
public class StatusController {
    private final TokenManagementService tokenManagementService;
    private final TerminalService terminalService;
    private final OrganizationService organizationService;

    public StatusController(TokenManagementService tokenManagementService, TerminalService terminalService) {
        this.tokenManagementService = tokenManagementService;
        this.terminalService = terminalService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServerStatus> getStatus() {
        ServerStatus serverStatus = new ServerStatus();
        serverStatus.setState(ServerState.GOOD);
        serverStatus.setTokens(tokenManagementService.getTokens());
        serverStatus.setTerminals(terminalService.findAll());
        serverStatus.setOrganizations(organizationService.f);

        return new ResponseEntity<>(sites, HttpStatus.OK);
    }
}
