package com.mx.banorte.services.services;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/gatewaySoap")
public class RestoSoapGatewayService {
    String resp = null;

    @GET            // Define el tipo como de nuestro endpoint como GET.
    @Path("/soap") // extension de nuestra direccion.
    @Produces(MediaType.APPLICATION_JSON)
    public Response llamadaSoap(){

    try {
        String soapBody = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n        <soap:Body><ns2:hello xmlns:ns2=\"http://unknown.namespace/\"><arg0>World</arg0></ns2:hello></soap:Body>\n       </soap:Envelope>\n</soap:Envelope>";

                HttpClient httpclient = new DefaultHttpClient();
                // You can get below parameters from SoapUI's Raw request if you are using that tool
                StringEntity strEntity = new StringEntity(soapBody, "text/xml", "UTF-8");
                // URL of request
                HttpPost post = new HttpPost("http://localhost:9090/soap/HelloService");
                post.setHeader("Content-Transfer-Encoding", "text/xml");
                post.setEntity(strEntity);
    
                // Execute request
                HttpResponse response = httpclient.execute(post);
                HttpEntity respEntity = response.getEntity();
    
                if (respEntity != null) {
                    resp = EntityUtils.toString(respEntity);       
                    //prints whole response
                    System.out.println(resp);
                } else {
                    System.err.println("No Response");
                }

    } catch (Exception e) {
        System.err.println("WebService SOAP exception = " + e.toString());
        return Response.status(500).entity("Error al consumir SOAP").build();
    }
    
        return Response.ok(resp, MediaType.APPLICATION_XML).build();  

    }

}
