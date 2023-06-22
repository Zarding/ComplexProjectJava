package com.zar.JavaServer.Service;

import com.zar.JavaServer.ClientRepository;
import com.zar.JavaServer.DocumentRepository;
import com.zar.JavaServer.Entity.Document;
import com.zar.JavaServer.Entity.TypeDocument;
import com.zar.JavaServer.Entity.UserClient;
import com.zar.JavaServer.TypeDocumentRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService{
    private final TypeDocumentRepository typeDocumentRepository;
    private final DocumentRepository documentRepository;

    public DocumentServiceImpl(TypeDocumentRepository typeDocumentRepository, DocumentRepository documentRepository) {
        super();
        this.typeDocumentRepository = typeDocumentRepository;
        this.documentRepository = documentRepository;
    }
    @Override
    public List<TypeDocument> getTypeDocumentsList() {
        return this.typeDocumentRepository.findAll();
    }

    @Override
    public List<Document> getDocumentsByClientId(Integer id) {
        return documentRepository.getDocumentsByClientId(id);
    }

    @Override
    public boolean AddDocument(Document doc) {
        try {
            documentRepository.save(doc);
            System.out.println(doc.getNumber());
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
