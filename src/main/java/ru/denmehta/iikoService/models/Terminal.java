package ru.denmehta.iikoService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "terminal")
public class Terminal extends  BaseEntity{
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    
    @Column()
    private String name;

    @Column()
    private String address;

    @Column()
    private String latitude;

    @Column()
    private String longitude;

    @Column()
    private Boolean isAlive;

    @Column()
    private Boolean isCheckAlive;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    @ManyToOne(targetEntity = Organization.class)
    @JsonIgnoreProperties("terminals")
    @JoinColumn(name="organizationId")
    private Organization organization;

    

}
