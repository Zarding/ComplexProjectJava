package com.zar.JavaServer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "number", length = 50)
    private String number;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_client")
    private Client idClient;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "date_finish")
    private LocalDate dateFinish;

    @Column(name = "status", length = 30)
    private String status;

    @Transient
    private Integer count_services;

    @JsonIgnore
    @OneToMany(mappedBy = "idPlan")
    private Set<TypeServicesPlan> typeServicesPlans = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<TypeServicesPlan> getTypeServicesPlans() {
        return typeServicesPlans;
    }

    public void setTypeServicesPlans(Set<TypeServicesPlan> typeServicesPlans) {
        this.typeServicesPlans = typeServicesPlans;
    }

    public void setCount_services(Integer count_services) {
        this.count_services = count_services;
    }

    public Integer getCount_services() {
        return count_services;
    }
}