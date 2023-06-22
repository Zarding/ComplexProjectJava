package com.zar.JavaServer.Service;

import com.zar.JavaServer.Entity.User;
import com.zar.JavaServer.Entity.UserClient;
import com.zar.JavaServer.UserClientRepository;
import com.zar.JavaServer.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserClientRepository userClientRepository;

    public UserServiceImpl(UserRepository userRepository, UserClientRepository userClientRepository) {
        super();
        this.userRepository = userRepository;
        this.userClientRepository = userClientRepository;
    }

    @Override
    public List<User> getUsersList() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(short id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getWorkerList() {
        return userRepository.findWorkers("Социальный работник");
    }

    @Override
    public void AddUserClient(UserClient userClient) {
        this.userClientRepository.save(userClient);
    }

    @Override
    public void DelUserClient(UserClient userClient) {
        this.userClientRepository.delete(userClient);
    }
}
