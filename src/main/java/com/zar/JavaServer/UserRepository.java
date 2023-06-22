package com.zar.JavaServer;

import com.zar.JavaServer.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {
    @Query("select u from User u where u.idRole.name = ?1")
    List<User> findWorkers(String name);

    List<User> findAll();
    User findById(short id);
}
