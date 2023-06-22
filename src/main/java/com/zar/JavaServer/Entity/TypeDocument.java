package com.zar.JavaServer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "type_document", indexes = {
        @Index(name = "unique_type_document", columnList = "name", unique = true)
})
public class TypeDocument {
    @Id
    @Column(name = "id", nullable = false)
    private Short id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "idTypeDocument")
    private Set<Document> documents = new LinkedHashSet<>();

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

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

}