package ru.denmehta.iikoService.request;

import com.sun.istack.NotNull;

import java.util.Date;

public class UpdateCustomerRequestBody {

    @NotNull
    private String email;

    private String name;

    private String surname;

    private String middleName;

    private Date birthday;

    private int sex;

    public int getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }


    public String getMiddleName() {
        return middleName;
    }


    public Date getBirthday() {
        return birthday;
    }

}
