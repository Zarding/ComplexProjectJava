package com.zar.JavaServer;

import com.zar.JavaServer.Entity.Service;
import com.zar.JavaServer.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceRepository extends CrudRepository<Service,Long> {
    @Query("select s from Service s where s.idTypeServices.id = ?1")
    List<Service> findByIdTypeService(Short id);
    @Override
    List<Service> findAll();
}
