package com.zar.JavaServer;

import com.zar.JavaServer.Entity.Service;
import com.zar.JavaServer.Entity.TypeServicesPlan;
import com.zar.JavaServer.Entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CalendarRepository extends CrudRepository<TypeServicesPlan,Long> {
    @Query("select t from TypeServicesPlan t where t.idUser.id = ?1 and t.status = ?2")
    List<TypeServicesPlan> findCalendarServicesByUser(Short id, String status);
    @Query("select t from TypeServicesPlan t where t.idUser.id = ?1 order by t.dateComplete")
    List<TypeServicesPlan> findCalendarServicesByUserId(Short id);

}
