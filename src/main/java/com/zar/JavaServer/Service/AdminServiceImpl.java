package com.zar.JavaServer.Service;

import com.zar.JavaServer.Entity.TypeService;
import com.zar.JavaServer.Entity.User;
import com.zar.JavaServer.ServiceRepository;
import com.zar.JavaServer.TypeServicesRepository;
import com.zar.JavaServer.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    private final UserRepository userRepository;

    private final ServiceRepository serviceRepository;

    private final TypeServicesRepository typeServicesRepository;

    public AdminServiceImpl(UserRepository userRepository, ServiceRepository serviceRepository, TypeServicesRepository typeServicesRepository) {
        super();
        this.userRepository = userRepository;
        this.serviceRepository = serviceRepository;
        this.typeServicesRepository = typeServicesRepository;
    }
    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public List<com.zar.JavaServer.Entity.Service> getServices() {
        return this.serviceRepository.findAll();
    }

    @Override
    public List<TypeService> getTypeServices() {
        return this.typeServicesRepository.findAll();
    }
}
