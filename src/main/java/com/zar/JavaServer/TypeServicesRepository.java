package com.zar.JavaServer;

import com.zar.JavaServer.Entity.TypeService;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeServicesRepository extends CrudRepository<TypeService, Long> {
    @Override
    List<TypeService> findAll();
}
