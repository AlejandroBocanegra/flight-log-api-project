package com.galvanize.flightlogapiproject;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightLogController {
    
    private final FlightLogRepository repository;

    public FlightLogController(FlightLogRepository repository) {this.repository= repository;}

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return this.repository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById (@PathVariable ("id") Long id) {
        Optional <User> i= this.repository.findById(id);
        if (i.isPresent()) {
            return i.get();
        } else {
            return null;
        }
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return this.repository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public Long deleteUserById (@PathVariable("id") Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return this.repository.count();
        } else {
            return null;
        }
    }

    @PutMapping("/users/{id}")
    public User updateUserBId (@PathVariable("id") Long id, @RequestBody User userUpdate) {
        if (this.repository.existsById(id)) {
            User user= this.repository.findById(id).get();
            if (userUpdate.getUserName() != null) {
                user.setUserName(userUpdate.getUserName());
            }

            if (userUpdate.getName() != null) {
                user.setName(userUpdate.getName());
            }

            if (userUpdate.getPassword() != null) {
                user.setPassword(userUpdate.getPassword());
            }

            if (userUpdate.getIsAdmin() != null) {
                user.setIsAdmin(userUpdate.getIsAdmin());
            }

            if (userUpdate.getIsPiloto() != null) {
                user.setIsPiloto(userUpdate.getIsPiloto());
            }

            return this.repository.save(user);
        } else {
            return null;
        }
    }  
    
    @PostMapping("/user/auth")
    public String updateUserBId (@RequestBody User authCheck) {
        Optional <User> user = this.repository.findByUserName(authCheck.getUserName());
        if (user.isPresent()) {
            String password = user.get().getPassword();
            if (password.equals(authCheck.getPassword())) {
                return "true";
            } else {
                return "invalid password";
            }
        } else {
            return "invalid user name";
        }
    }

}