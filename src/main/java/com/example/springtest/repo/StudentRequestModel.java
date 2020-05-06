package com.example.springtest.repo;

import com.javaoutofbounds.HelloStudentRequest;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StudentRequestModel {
    @Id
    public String id;

    public String imputName;
    public StudentRequestModel(HelloStudentRequest request) {
        this.imputName = request.getInputName();
    }

//    public HelloStudentRequest imputName;
//    public StudentRequestModel(HelloStudentRequest request) {
//        this.imputName = request;
//    }


}
