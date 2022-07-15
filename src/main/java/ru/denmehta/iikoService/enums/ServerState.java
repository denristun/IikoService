package ru.denmehta.iikoService.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum ServerState {

    GOOD("good"),
    BAD("bad"),
    WARNING("warning"),
    DOWN("down");

    private final String state;

}
