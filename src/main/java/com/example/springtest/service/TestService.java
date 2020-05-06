package com.example.springtest.service;

import com.example.springtest.repo.Customer;
import com.example.springtest.repo.CustomerRepository;
import com.example.springtest.repo.StudentRequestModel;
import com.example.springtest.repo.StudentRequestRepo;
import com.javaoutofbounds.HelloStudentRequest;
import com.javaoutofbounds.HelloStudentResponse;
import com.javaoutofbounds.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService implements Students {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private StudentRequestRepo studentrepo;

    @Override
    public HelloStudentResponse helloStudent(HelloStudentRequest requestPart) {
        HelloStudentResponse test = new HelloStudentResponse();
        String str  = requestPart.getInputName();
        test.setOutputResult(str + " Hello");
        studentrepo.save(new StudentRequestModel(requestPart));
        repository.save(new Customer("Alice", "Smith"));
        return test;
    }
}
