package com.zar.JavaServer.Service;

import com.zar.JavaServer.Entity.Document;
import com.zar.JavaServer.Entity.TypeDocument;

import java.util.List;

public interface DocumentService {
    List<TypeDocument> getTypeDocumentsList();

    List<Document> getDocumentsByClientId(Integer id);
    boolean AddDocument(Document doc);
    void DelDocument(Document doc);
}
