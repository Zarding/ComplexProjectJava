package com.zar.JavaServer.Service;

import com.zar.JavaServer.Entity.Reference;
import com.zar.JavaServer.Entity.TypeReference;
import com.zar.JavaServer.ReferenceRepository;
import com.zar.JavaServer.TypeReferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenceServiceImpl implements ReferenceService{

    private final ReferenceRepository referenceRepository;
    private final TypeReferenceRepository typeReferenceRepository;

    public ReferenceServiceImpl(ReferenceRepository referenceRepository, TypeReferenceRepository typeReferenceRepository) {
        this.referenceRepository = referenceRepository;
        this.typeReferenceRepository = typeReferenceRepository;
    }
    @Override
    public List<Reference> getReferencesByClientId(Integer id) {
        return referenceRepository.getReferencesByClientId(id);
    }

    @Override
    public List<TypeReference> getAllTypeReferences() {
        return this.typeReferenceRepository.findAll();
    }

    @Override
    public void AddReference(Reference reference) {
        try {
            System.out.println(reference.getContent());
            System.out.println(reference.getDate());
            System.out.println(reference.getTypeReference().getType());
            //System.out.println(reference.);
            referenceRepository.save(reference);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
