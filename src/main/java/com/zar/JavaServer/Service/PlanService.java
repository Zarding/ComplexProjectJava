package com.zar.JavaServer.Service;

import com.zar.JavaServer.Entity.Plan;
import com.zar.JavaServer.Entity.TypeServicesPlan;

import java.util.List;

public interface PlanService {
    List<Plan> getPlansByClientId(Integer id);
    Integer getCountServicesByPlanId(Integer id);
    Plan getPlanById(Integer id);
    List<TypeServicesPlan> getTypeServicesPlansByPlanId(Integer id);

    void AddPlan(List<TypeServicesPlan> tsp);
}
