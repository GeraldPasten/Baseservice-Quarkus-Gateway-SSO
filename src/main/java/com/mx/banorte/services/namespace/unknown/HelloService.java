package com.mx.banorte.services.namespace.unknown;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.5.5
 * 2023-08-23T10:47:27.023-04:00
 * Generated source version: 3.5.5
 *
 */
@WebService(targetNamespace = "http://unknown.namespace/", name = "HelloService")
@XmlSeeAlso({ObjectFactory.class})
public interface HelloService {

    @WebMethod
    @RequestWrapper(localName = "hello", targetNamespace = "http://unknown.namespace/", className = "namespace.unknown.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://unknown.namespace/", className = "namespace.unknown.HelloResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String hello(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
