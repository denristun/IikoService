package ru.denmehta.iikoService.iiko.classes;

import com.sun.istack.NotNull;
import ru.denmehta.iikoService.iiko.enums.SearchScope;

public class PaymentAdditionalData {

    @NotNull
    private String credential;

    @NotNull
    private SearchScope searchScope;

    @NotNull
    private final String type = "IikoCard";

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public void setSearchScope(SearchScope searchScope) {
        this.searchScope = searchScope;
    }
}
