package com.zar.JavaServer;

import com.zar.JavaServer.Entity.Plan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlanRepository extends CrudRepository<Plan,Long> {
    @Query("select p from Plan p where p.id = ?1")
    Plan findPlanById(Integer id);
    @Query("select p from Plan p where p.idClient.id = ?1")
    List<Plan> findPlansByClientId(Integer id);
}
