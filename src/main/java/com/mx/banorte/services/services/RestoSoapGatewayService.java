package com.mx.banorte.services.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

// import namespace.unknown.HelloService; 
import io.quarkiverse.cxf.annotation.CXFClient;

@Path("/gatewaySoap")
public class RestoSoapGatewayService {
    
    // @CXFClient("hService")
    // HelloService hService;

    // @GET
    // @Path("/hello") // Operacion en WSDL
    // @Produces(MediaType.APPLICATION_JSON)
    // public String add(@QueryParam("nombre") String nombre) {

    //     return hService.hello(nombre);
    // }


}
