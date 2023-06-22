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
@Table(name = "type_reference", indexes = {
        @Index(name = "unique_type_reference", columnList = "type", unique = true)
})
public class TypeReference {
    @Id
    @Column(name = "id", nullable = false)
    private Short id;

    @Column(name = "type", nullable = false)
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "typeReference")
    private Set<Reference> references = new LinkedHashSet<>();

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

    public Set<Reference> getReferences() {
        return references;
    }

    public void setReferences(Set<Reference> references) {
        this.references = references;
    }

}