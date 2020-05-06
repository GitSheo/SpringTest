package com.example.springtest.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface StudentRequestRepo extends MongoRepository<StudentRequestModel, String> {
}
