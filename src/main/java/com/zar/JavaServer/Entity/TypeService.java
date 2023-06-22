package com.zar.JavaServer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "type_services", indexes = {
        @Index(name = "unique_type_services", columnList = "type", unique = true)
})
public class TypeService {
    @Id
    @Column(name = "id", nullable = false)
    private Short id;

    @Column(name = "type", nullable = false)
    private String type;


    @JsonIgnore
    @OneToMany(mappedBy = "idTypeServices")
    private Set<Service> services = new LinkedHashSet<>();

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

}