package com.zar.JavaServer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "\"user\"", indexes = {
        @Index(name = "unique_login", columnList = "login", unique = true),
        @Index(name = "user_id_worker_key", columnList = "id_worker", unique = true)
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial", insertable = false, updatable = false)
    private Short id;

    @Column(name = "login", nullable = false, length = 20)
    private String login;

    @Column(name = "password", length = 64)
    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_worker")
    private Worker idWorker;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role")
    private Role idRole;

    @JsonIgnore
    @OneToMany(mappedBy = "idUser")
    private Set<Reference> references = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "idUser")
    private Set<UserClient> userClients = new LinkedHashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "idUser")
    private Set<TypeServicesPlan> typeServicesPlans = new LinkedHashSet<>();

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Worker getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(Worker idWorker) {
        this.idWorker = idWorker;
    }

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

    public Set<Reference> getReferences() {
        return references;
    }

    public void setReferences(Set<Reference> references) {
        this.references = references;
    }

    public Set<UserClient> getUserClients() {
        return userClients;
    }

    public void setUserClients(Set<UserClient> userClients) {
        this.userClients = userClients;
    }

    public Set<TypeServicesPlan> getTypeServicesPlans() {
        return typeServicesPlans;
    }

    public void setTypeServicesPlans(Set<TypeServicesPlan> typeServicesPlans) {
        this.typeServicesPlans = typeServicesPlans;
    }

}