package com.zar.JavaServer;

import com.zar.JavaServer.Entity.Document;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DocumentRepository extends CrudRepository<Document,Long> {
    @Query("select d from Document d where d.idClient.id = ?1")
    List<Document> getDocumentsByClientId(Integer id);

}
