package ru.denmehta.iikoService.models;

import lombok.Data;
import ru.denmehta.iikoService.enums.ServerState;

import java.util.List;
import java.util.Map;

@Data
public class ServerStatus {

//    private ServerState state;

    private List<Organization> organizations;

    private List<Terminal> terminals;

    private Map<String, String> tokens;


}
