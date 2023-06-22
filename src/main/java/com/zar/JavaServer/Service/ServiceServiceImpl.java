package com.zar.JavaServer.Service;

import com.zar.JavaServer.Entity.TypeService;
import com.zar.JavaServer.Entity.TypeServicesPlan;
import com.zar.JavaServer.ServiceRepository;
import com.zar.JavaServer.TypeServicesPlanRepository;
import com.zar.JavaServer.TypeServicesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    private final TypeServicesRepository typeServicesRepository;
    private final ServiceRepository serviceRepository;
    private final TypeServicesPlanRepository typeServicesPlanRepository;
    public ServiceServiceImpl(TypeServicesRepository typeServicesRepository, ServiceRepository serviceRepository, TypeServicesPlanRepository typeServicesPlanRepository) {
        super();
        this.typeServicesRepository = typeServicesRepository;
        this.serviceRepository = serviceRepository;
        this.typeServicesPlanRepository = typeServicesPlanRepository;
    }
    @Override
    public List<TypeService> getAllTypeServices() {
        return typeServicesRepository.findAll();
    }

    @Override
    public List<com.zar.JavaServer.Entity.Service> getAllServicesByTypeServicesId(short id) {
        return serviceRepository.findByIdTypeService(id);
    }

    @Override
    public void updateTypeServicesPlan(TypeServicesPlan tsp) {
        tsp.setStatus("Завершено");
        typeServicesPlanRepository.save(tsp);
    }
}
