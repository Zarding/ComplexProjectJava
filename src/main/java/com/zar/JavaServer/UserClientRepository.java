package com.zar.JavaServer;

import com.zar.JavaServer.Entity.UserClient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserClientRepository extends CrudRepository<UserClient,Long> {
    @Query("select u from UserClient u where u.idClient.id = ?1")
    List<UserClient> findUsersByClientId(Integer id);
}
