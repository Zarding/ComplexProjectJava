package com.zar.JavaServer.Controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zar.JavaServer.Entity.Client;
import com.zar.JavaServer.Entity.Plan;
import com.zar.JavaServer.Entity.TypeServicesPlan;
import com.zar.JavaServer.Service.PlanService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlanController {
    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping(value = "/servicesplans/{id}")
    public List getDocumentsByClientId(@PathVariable("id") Integer id){
        return planService.getPlansByClientId(id);
    }

    @GetMapping(value = "/servicescount/{id}")
    public Integer getCountServicesByPlanId(@PathVariable("id") Integer id){
        return planService.getCountServicesByPlanId(id);
    }

    @GetMapping(value = "/serviceplan/{id}")
    public Plan getPlanById(@PathVariable("id") Integer id){
        return planService.getPlanById(id);
    }

    @GetMapping(value = "/typeserviceplan/{id}")
    public List getTypeServicesPlanById(@PathVariable("id") Integer id){
        return planService.getTypeServicesPlansByPlanId(id);
    }

    @PostMapping(value="/addplan")
    public void addPlan(@RequestBody List<TypeServicesPlan> tsp){
        this.planService.AddPlan(tsp);
    }
}
