package com.mx.banorte.services.soapservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mx.banorte.services.mo.ObjectXml;


@WebService(name = "SoapService", serviceName = "SoapService") // Se indica el nombre de nuestro servicio
public interface SoapService { // Interface Soap Service que sera heredada por SoapServiceResta y SoapServiceSuma
    
    @WebMethod
    String autenticarUsuarioIn(ObjectXml objetoXml, String json);
}
