package com.zar.JavaServer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "client", indexes = {
        @Index(name = "unique_client", columnList = "snils", unique = true)
})
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "secondname", nullable = false, length = 20)
    private String secondname;

    @Column(name = "otchestvo", length = 25)
    private String otchestvo;

    @Column(name = "sex", length = 4)
    private String sex;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "snils", length = 15)
    private String snils;

    @Column(name = "polis_oms", length = 19)
    private String polisOms;

    @Column(name = "place_last_live")
    private String placeLastLive;

    @Column(name = "place_last_reg")
    private String placeLastReg;

    @Column(name = "attribute", length = 100)
    private String attribute;

    @Column(name = "photo")
    private String photo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_social_status")
    private Socialstatus idSocialStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "idClient")
    private Set<Plan> plans = new LinkedHashSet<>();


    @JsonIgnore
    @OneToMany(mappedBy = "idClient")
    private Set<Document> documents = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "idClient")
    private Set<Reference> references = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idClient")
    private Set<UserClient> userClients = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String getPolisOms() {
        return polisOms;
    }

    public void setPolisOms(String polisOms) {
        this.polisOms = polisOms;
    }

    public String getPlaceLastLive() {
        return placeLastLive;
    }

    public void setPlaceLastLive(String placeLastLive) {
        this.placeLastLive = placeLastLive;
    }

    public String getPlaceLastReg() {
        return placeLastReg;
    }

    public void setPlaceLastReg(String placeLastReg) {
        this.placeLastReg = placeLastReg;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Socialstatus getIdSocialStatus() {
        return idSocialStatus;
    }

    public void setIdSocialStatus(Socialstatus idSocialStatus) {
        this.idSocialStatus = idSocialStatus;
    }

    public Set<Plan> getPlans() {
        return plans;
    }

    public void setPlans(Set<Plan> plans) {
        this.plans = plans;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public Set<Reference> getReferences() {
        return references;
    }

    public void setReferences(Set<Reference> references) {
        this.references = references;
    }
    @JsonIgnore
    public Set<UserClient> getUserClients() {
        return userClients;
    }

    public void setUserClients(Set<UserClient> userClients) {
        this.userClients = userClients;
    }

}