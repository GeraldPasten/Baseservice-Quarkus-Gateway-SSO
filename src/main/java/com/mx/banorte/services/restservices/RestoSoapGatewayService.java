package com.mx.banorte.services.restservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;

import com.mx.banorte.services.namespace.unknown.HelloService; // Clase generada a partir del servicio soap wsdl
import io.quarkiverse.cxf.annotation.CXFClient; // Cliente CXF utilizado para declarar la variable hservice

/* Descripcion de esta clase:
 * En esta clase se muestra un ejemplo de como hacer una llamada Rest to Soap.
 * 
 * En el metodo "add" se realiza una llamada a un api SOAP desde un punto REST,
 * 
 * Descripcion Anotaciones:
 * @Path("/gatewaySoap") = Define la raiz de al direccion de nuestro endpoint.
 * @GET = Define el tipo como de nuestro endpoint como GET, tambien pueden usarse (POST, PUT, DELETE).
 * @Path("/hello") = Dependiendo donde se encuentre, puede ser tanto a raiz como la extension de nuestra direccion como por ejemplo http//localhost:8080//gatewaySoap/hello. 
 * @Produces = Define el tipo de respuesta que va producir nuestro endpoint (Json, Xml, Text).
 * 
 * Descripcion Funcional:
 * Este es un ejemplo de un punto rest que consume a un servicio SOAP, es decir un intermediario de un punto A a un punto B.
 *  
 * En donde se llama a las clases autogeneradas por wsdl2java, que toma el contrato wsdl del servicio SOAP que se quiere llamar y genera las clases necesarias para consumirlo.
 * 
 * Estas clases se generan en /target/generated-sources/wsdl2java.
 * 
 * Para consumir este servicio se importa la clase generada namespace.unknown.HelloService.
 * Que contiente una interfaz de servicio web llamada HelloService utilizando anotaciones de Apache CXF para configurar cómo se empaquetan y desempaquetan los mensajes SOAP y sus parámetros. 
 * El método hello dentro de esta interfaz representa la operación que el servicio SOAP proporciona.
 * 
 * 
 * 
 * @Author Red hat
 */

@Path("/rest")
public class RestoSoapGatewayService {

    @CXFClient("hService") // Se referencia al cliente cxf hService 
    HelloService hService; // Definimos la clase HellosService en donde tenemos el metodo "hello" de la clase HelloService

    @GET
    @Path("/redirect/soap")
    @Produces(MediaType.APPLICATION_JSON) // Indicar  que produciremos un JSON en las respuesta
    @Consumes(MediaType.APPLICATION_JSON) // Indicar que esperamos recibir un cuerpo JSON en la solicitud
    public Response restToSoapCall(String requestBody) { // requestBody es el JSON que recibira el servicio  y Response el tipo de objeto que se retornara

        try {
    
            return Response.ok(hService.hello(requestBody), MediaType.APPLICATION_JSON).build(); // se retorna como objeto response la respuesta del servicio SOAP que estamos consumiendo

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR) // retornamos status de error interno del servidor en conjunto a un mensaje.
            .entity("Error en la llamada rest to soap") // respuesta con mensaje de error 
            .type(MediaType.APPLICATION_JSON) // tipo APPLICATION_JSON
            .build(); // Contruccion de nuestra entidad Response

        }
    }

}
