package com.zar.JavaServer.Service;

import com.zar.JavaServer.Entity.Service;
import com.zar.JavaServer.Entity.TypeReference;
import com.zar.JavaServer.Entity.TypeService;
import com.zar.JavaServer.Entity.TypeServicesPlan;

import java.util.List;

public interface ServiceService {
    List<TypeService> getAllTypeServices();
    List<Service> getAllServicesByTypeServicesId(short id);

    void updateTypeServicesPlan(TypeServicesPlan tsp);
}
