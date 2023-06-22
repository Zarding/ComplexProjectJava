package com.zar.JavaServer.Controller;

import com.zar.JavaServer.Entity.Reference;
import com.zar.JavaServer.Entity.TypeServicesPlan;
import com.zar.JavaServer.Service.ServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceController {
    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }
    @GetMapping(value = "/services/{id}")
    public List getClientsByUserId(@PathVariable("id") short id){
        return serviceService.getAllServicesByTypeServicesId(id);
    }

    @PostMapping(value="/services/update")
    public void saveReference(@RequestBody TypeServicesPlan typeServicesPlan){
        serviceService.updateTypeServicesPlan(typeServicesPlan);
    }
}
