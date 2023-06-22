package com.zar.JavaServer.Service;

import com.zar.JavaServer.Entity.Plan;
import com.zar.JavaServer.Entity.TypeServicesPlan;
import com.zar.JavaServer.PlanRepository;
import com.zar.JavaServer.TypeServicesPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;

    private final TypeServicesPlanRepository typeServicesPlanRepository;

    public PlanServiceImpl(PlanRepository planRepository, TypeServicesPlanRepository typeServicesPlanRepository) {
        this.planRepository = planRepository;
        this.typeServicesPlanRepository = typeServicesPlanRepository;
    }
    @Override
    public List<Plan> getPlansByClientId(Integer id) {
        List<Plan> plans = planRepository.findPlansByClientId(id);
        for (Plan plan : plans) {
            plan.setCount_services(typeServicesPlanRepository.getCountServicesByPlanId(plan.getId()));
        }
        return plans;
    }

    @Override
    public Integer getCountServicesByPlanId(Integer id) {
        return typeServicesPlanRepository.getCountServicesByPlanId(id);
    }

    @Override
    public Plan getPlanById(Integer id) {
        return planRepository.findPlanById(id);
    }

    @Override
    public List<TypeServicesPlan> getTypeServicesPlansByPlanId(Integer id) {
        return typeServicesPlanRepository.findTypeServicesPlanByPlanId(id);
    }

    @Override
    public void AddPlan(List<TypeServicesPlan> tsp) {
        Plan plan = tsp.get(0).getIdPlan();
        plan.setStatus("Новый");
        planRepository.save(plan);
        for (TypeServicesPlan tsp0 : tsp) {
            tsp0.setStatus("Новый");
            tsp0.setIdPlan(plan);
            typeServicesPlanRepository.save(tsp0);
        }
    }

    @Override
    public void AddTypeServicesPlan(TypeServicesPlan tsp) {
        typeServicesPlanRepository.save(tsp);
    }
}
