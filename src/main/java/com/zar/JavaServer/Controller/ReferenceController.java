package com.zar.JavaServer.Controller;

import com.zar.JavaServer.Entity.Document;
import com.zar.JavaServer.Entity.Reference;
import com.zar.JavaServer.Service.DocumentService;
import com.zar.JavaServer.Service.ReferenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReferenceController {
    private final ReferenceService referenceService;

    public ReferenceController(ReferenceService referenceService) {
        this.referenceService = referenceService;
    }

    @GetMapping(value = "/references/{id}")
    public List getReferencesByClientId(@PathVariable("id") Integer id){
        return referenceService.getReferencesByClientId(id);
    }

    @GetMapping(value = "/typereferences")
    public List getTypeReferences(){
        return referenceService.getAllTypeReferences();
    }

    @PostMapping(value="/addreference")
    public void saveReference(@RequestBody Reference reference){
        referenceService.AddReference(reference);
    }
}
