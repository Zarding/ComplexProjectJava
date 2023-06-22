package com.zar.JavaServer;

import com.zar.JavaServer.Entity.Socialstatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SocialStatusRepository extends CrudRepository<Socialstatus,Long> {
    List<Socialstatus> findAll();
}
