package com.zar.JavaServer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "documents", indexes = {
        @Index(name = "unique_serial_number", columnList = "id_client, number, serial", unique = true)
})
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "number", length = 30)
    private String number;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_client")
    private Client idClient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_document")
    private TypeDocument idTypeDocument;

    @Column(name = "serial", length = 10)
    private String serial;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "organ", length = 100)
    private String organ;

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

    public TypeDocument getIdTypeDocument() {
        return idTypeDocument;
    }

    public void setIdTypeDocument(TypeDocument idTypeDocument) {
        this.idTypeDocument = idTypeDocument;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

}