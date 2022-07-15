package ru.denmehta.iikoService.converters;

import org.springframework.core.convert.converter.Converter;
import ru.denmehta.iikoService.enums.ServerState;

public class ServerStateToStringConverter implements Converter<ServerState, String> {
    @Override
    public String convert(ServerState source) {
        return source.getState();
    }
}
