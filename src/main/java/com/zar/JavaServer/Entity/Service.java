package com.zar.JavaServer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "services", indexes = {
        @Index(name = "unique_services", columnList = "name, id_type_services, type", unique = true)
})
public class Service {
    @Id
    @Column(name = "id", nullable = false)
    private Short id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "type", nullable = false, length = 15)
    private String type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_services")
    private TypeService idTypeServices;

    @JsonIgnore
    @OneToMany(mappedBy = "idServices")
    private Set<TypeServicesPlan> typeServicesPlans = new LinkedHashSet<>();

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TypeService getIdTypeServices() {
        return idTypeServices;
    }

    public void setIdTypeServices(TypeService idTypeServices) {
        this.idTypeServices = idTypeServices;
    }

    public Set<TypeServicesPlan> getTypeServicesPlans() {
        return typeServicesPlans;
    }

    public void setTypeServicesPlans(Set<TypeServicesPlan> typeServicesPlans) {
        this.typeServicesPlans = typeServicesPlans;
    }

}