package com.zar.JavaServer.Controller;

import com.zar.JavaServer.DocumentRepository;
import com.zar.JavaServer.Entity.Client;
import com.zar.JavaServer.Entity.Document;
import com.zar.JavaServer.Service.DocumentService;
import com.zar.JavaServer.SocialStatusRepository;
import com.zar.JavaServer.TypeDocumentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping(value = "/typedocuments")
    public List getTypeDocuments(){
        return documentService.getTypeDocumentsList();
    }

    @GetMapping(value = "/documents/{id}")
    public List getDocumentsByClientId(@PathVariable("id") Integer id){
        return documentService.getDocumentsByClientId(id);
    }

    @PostMapping(value="/adddocument")
    public boolean saveDoc(@RequestBody Document document){
        System.out.println(document.getNumber());
        return documentService.AddDocument(document);
    }
}
