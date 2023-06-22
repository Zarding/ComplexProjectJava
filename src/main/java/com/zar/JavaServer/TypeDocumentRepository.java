package com.zar.JavaServer;

import com.zar.JavaServer.Entity.TypeDocument;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeDocumentRepository extends CrudRepository<TypeDocument,Long> {
    List<TypeDocument> findAll();
}
