package com.zar.JavaServer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "role", indexes = {
        @Index(name = "unique_role", columnList = "name", unique = true)
})
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    private Short id;

    @Column(name = "name", length = 50)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "idRole")
    private Set<User> users = new LinkedHashSet<>();

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}