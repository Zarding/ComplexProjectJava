package com.zar.JavaServer;

import com.zar.JavaServer.Entity.Reference;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReferenceRepository extends CrudRepository<Reference,Long> {
    @Query("select r from Reference r where r.idClient.id = ?1")
    List<Reference> getReferencesByClientId(Integer id);
}
