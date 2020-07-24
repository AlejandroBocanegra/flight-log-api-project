package com.galvanize.flightlogapiproject;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FlightLogRepository extends CrudRepository<User, Long> {
    
    @Query(value= "SELECT * FROM users WHERE id = :id", nativeQuery=true)
    User findPorUserId(Long id);

    Optional <User> findByUserName (String userName);
}