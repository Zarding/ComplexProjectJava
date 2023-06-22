package com.zar.JavaServer.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "socialstatus", indexes = {
        @Index(name = "unique_social_status", columnList = "name", unique = true)
})
public class Socialstatus {
    @Id
    @Column(name = "id", nullable = false)
    private Short id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

/*    @OneToMany(mappedBy = "idSocialStatus")
    private Set<Client> clients = new LinkedHashSet<>();*/

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

/*    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }*/

}