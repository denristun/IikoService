package ru.denmehta.iikoService.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "site")
public class Site extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column
    private String domain;

    @Column
    private String token;

    @Column
    private String apiLogin;

    @Column
    private boolean active;


    @OneToMany(mappedBy="site", targetEntity = Group.class)
    private Set<Group> groups;

    @OneToMany(mappedBy="site", targetEntity = Organization.class)
    private Set<Organization> organizations;

    @ManyToMany(mappedBy = "sites")
    private Set<Customer> customers = new HashSet<>();

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getApiLogin() {
        return apiLogin;
    }

    public void setApiLogin(String apiLogin) {
        this.apiLogin = apiLogin;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
