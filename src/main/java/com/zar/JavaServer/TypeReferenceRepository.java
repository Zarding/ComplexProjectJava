package com.zar.JavaServer;

import com.zar.JavaServer.Entity.TypeDocument;
import com.zar.JavaServer.Entity.TypeReference;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeReferenceRepository extends CrudRepository<TypeReference,Long> {
    @Override
    List<TypeReference> findAll();
}
