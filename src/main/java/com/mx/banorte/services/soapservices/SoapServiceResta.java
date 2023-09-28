package com.mx.banorte.services.soapservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mx.banorte.services.mo.ObjectXml;
import com.mx.banorte.services.namespace.unknown.HelloService; // Clase generada a partir del servicio soap wsdl
import com.mx.banorte.services.restservices.RestoRestGatewayService;

import io.quarkiverse.cxf.annotation.CXFClient; // Cliente CXF utilizado para declarar la variable hservice


/* Descripcion de esta clase:
 * En esta clase se muestra un ejemplo de como seria la comuniacion SOAP to SOAP
 * Donde se expone un endpoint SOAP con el path serviceSoap/resta
 * dentro de este metodo se utiliza la clase autogenerada mediante el contrato wsdl por wsdl2java, para el consumo de un servicio SOAP.
 * 
 * 
 * @Author Red hat
 */

@WebService(serviceName = "serviceSoap/resta") // "serviceName/resta" indica el path de nuestro servicio SOAP
public class SoapServiceResta implements SoapService { // esta clase extiende de SoapService

    @CXFClient("hService") // Inicializamos el cliente cxf con el servicio hService indicando en properties quarkus.cxf.client.hService
                            
    HelloService hService; // Se le hace mension a la clase HelloService autogenerada mediante el contrato wsdl por wsdl2java, que contiene el metodo hello
                          

    RestoRestGatewayService restRedirect = new RestoRestGatewayService(); // Clase con un consumo REST

    @WebMethod
    @Override
    public String autenticarUsuarioIn(ObjectXml body, String json) {

        String tipoAuth = body.getTipoAutenticacion();
        String respUsuario = body.getRespUsuario();
        String respBianria = String.valueOf(body.isRespBinaria());
        String respBinariaUsuario = body.getRespBinariaUsuario();

        try {

            // AutenticarUsuarioIn
            if ("?".equals(tipoAuth) && "?".equals(respUsuario) && "false".equals(respBianria) && respBinariaUsuario != null && respBinariaUsuario.length() > 0) {
                
                return restRedirect.callRest(json);
            // Cerrar sesion
            } else if ("?".equals(tipoAuth) && respUsuario == null && "false".equals(respBianria) && respBinariaUsuario == null) {
                
                return hService.hello(tipoAuth + " " + respUsuario + " " + respBianria + " " + respBinariaUsuario);
            }

            return tipoAuth + " " + respUsuario + " " + respBianria + " " + respBinariaUsuario;
                                                                                                

        } catch (Exception e) {
            e.printStackTrace();
            return "Error en la llamada soap to soap";
        }

    }
}
