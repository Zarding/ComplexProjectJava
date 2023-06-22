package com.zar.JavaServer.Service;

import com.zar.JavaServer.Entity.Document;
import com.zar.JavaServer.Entity.Reference;
import com.zar.JavaServer.Entity.TypeReference;

import java.util.List;

public interface ReferenceService {
    List<Reference> getReferencesByClientId(Integer id);

    List<TypeReference> getAllTypeReferences();

    void AddReference(Reference reference);
    void DelReference(Reference reference);
}
