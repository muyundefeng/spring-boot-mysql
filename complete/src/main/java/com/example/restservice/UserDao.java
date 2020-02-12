package com.example.restservice;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

}
