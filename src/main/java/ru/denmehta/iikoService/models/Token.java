package ru.denmehta.iikoService.models;

import lombok.Data;

@Data
public class Token {

    private Site site;

    private String token;
}
