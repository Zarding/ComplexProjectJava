package com.zar.JavaServer;

import com.zar.JavaServer.Entity.TypeServicesPlan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeServicesPlanRepository extends CrudRepository<TypeServicesPlan,Long> {
    @Query("select t from TypeServicesPlan t where t.idPlan.id = ?1")
    List<TypeServicesPlan> findTypeServicesPlanByPlanId(Integer id);
    @Query("select count(t) from TypeServicesPlan t where t.idPlan.id = ?1")
    Integer getCountServicesByPlanId(Integer id);
}
