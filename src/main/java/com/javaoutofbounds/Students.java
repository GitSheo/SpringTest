package com.javaoutofbounds;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2020-04-16T19:39:09.364+05:00
 * Generated source version: 3.0.4
 * 
 */
@WebService(targetNamespace = "http://www.javaoutofbounds.com", name = "students")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface Students {

    @WebMethod(action = "http://www.javaoutofbounds.com")
    @WebResult(name = "helloStudentResponse", targetNamespace = "http://www.javaoutofbounds.com", partName = "responsePart")
    public HelloStudentResponse helloStudent(
        @WebParam(partName = "requestPart", name = "helloStudentRequest", targetNamespace = "http://www.javaoutofbounds.com")
        HelloStudentRequest requestPart
    );
}