package com.mx.banorte.services.services;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/* Descripcion de esta clase:
 * En esta clase se muestra un ejemplo de como hacer una llamada Rest to Rest.
 * 
 * En el metodo "redirigirSolicitudBasicAuthandTLS" se realiza una llamada a un api rest,
 * en donde se muestra como cargar un certificado tls, configurar el cliente JAX-RS con el mismo,
 * como se crea una solicitud con los encabezados necesarios para una autenticacion basica,
 * como recibir la respuesta de esta solicitud mediante *response.readEntity()*.
 * 
 * Descripcion Anotaciones:
 * @Path("/") = Define la raiz de al direccion de nuestro endpoint.
 * @ConfigProperty = Define una variable de entorno la cual va a contener el valor que se especifique en el archivo properties.
 * @GET = Define el tipo como de nuestro endpoint como GET, tambien pueden usarse (POST, PUT, DELETE).
 * @Path("/rest") = Dependiendo donde se encuentre, puede ser tanto a raiz como la extension de nuestra direccion como por ejemplo http//localhost:8081/gateway/rest. 
 * @Produces = Define el tipo de respuesta que va producir nuestro endpoint (Json, Xml, Text).
 * 
 * Descripcion Funcional:
 * Este es un ejemplo de un gateway, es decir un intermediario de un punto A a un punto B.
 * 
 * La url del servicio que se va a consumir se especifica en la variable de entorno "servicioExterno",
 * que se utilizara al crear la solicitud mediante *builder = client.target(servicioExterno)*.
 * 
 * luego se recibe la respuesta de esta solicutud en variable respuesta en donde se define que sera response.readEntity(String.class);
 *  
 * 
 * Ese seria el funcionamiento basico de un gateway, pero si bien se sabe que no solo es consumir sin ningun requisito previo,
 * el servicio puede tener seguridad, como por ejemplo utenticacion basica, y certificado TLS.  
 * 
 * Poniendonos bajo este contexto se muestran ejemplos de como pasar el header de autenticacion basica,
 * y como cargar un certificado TLS. 
 * 
 *  SSLContext = Crea una nueva instancia utilizando el protocola TLS.
 *  TrustManagerFactory = Crea una nueva instancia utilizando el algoritmo por defecto.
 *  Client = crear una instancia donde configurar el cliente JAX-RS con el certificado.
 *  Invocation.Builder = Establece el objetivo de la solicitud.
 *  Response = Esto envía la solicitud al servidor y espera la respuesta.
 * 
 *  throws:
 *  NoSuchAlgorithmException = Esta excepción se lanza cuando se solicita un algoritmo que no está disponible en el entorno de ejecución. Por ejemplo, si se solicita un algoritmo de cifrado o de generación de claves que no está soportado.
 *  KeyStoreException = Esta excepción se lanza cuando ocurre un error relacionado con el almacenamiento de claves, como problemas al acceder a un almacén de claves o manipular claves dentro del almacén.
 *  KeyManagementException = Esta excepción se lanza cuando ocurre un error en la configuración o gestión del contexto de SSL/TLS. Puede ocurrir, por ejemplo, si hay un problema al inicializar o configurar el contexto de SSL/TLS.
 * 
 * @Author Red hat
 */

@Path("/gateway") // Define la raiz de al direccion de nuestro endpoint.
public class RestoRestGatewayService {

    @ConfigProperty(name = "servicio.externo.url") // Define una variable de entorno la cual va a contener el valor que se especifique en el archivo properties.
    String servicioExterno;

    @GET // Define el tipo como de nuestro endpoint como GET.
    @Path("/rest") // extension de nuestra direccion.
    @Produces(MediaType.APPLICATION_JSON)
    public String redirigirSolicitudBasicAuthandTLS() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
    try {
        // Cargar el certificado
            /* SSLContext sslContext = SSLContext.getInstance("TLS"); // Crea una nueva instancia utilizando el protocola TLS
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm()); //Crea una nueva instancia utilizando el algoritmo por defecto.

            trustManagerFactory.init(KeyStore.getInstance(KeyStore.getDefaultType())); // Inicializa trust manager factory cargando el tipo keystore
            sslContext.init(null, trustManagerFactory.getTrustManagers(), null); // Inicializa el contexto SSL/TLS // los valores null indican que el contexto debe usar valores pode defecto */

        // Configurar el cliente JAX-RS con el certificado
         Client client = ClientBuilder.newBuilder()  
                    //.sslContext(sslContext)  Configura el cliente para usar el sslContext que se creó anteriormente
                    .build();

         // Crear la solicitud con los encabezados de autorización
         Invocation.Builder builder = client.target(servicioExterno) // Establece el objetivo de la solicitud, es decir, la URL del servicio externo al que deseas realizar la invocación.
         .request(MediaType.APPLICATION_JSON) // Establece el tipo de contenido que se espera en la respuesta del servicio externo, en este caso JSON. 
         .header("Authorization", "Basic " + "tokenUtenticacionBasica"); // Agrega un encabezado de autorización a la solicitud "tokenUtenticacionBasica" debe ser la credencial.

        // Realizar la llamada y obtener la respuesta
        Response response = builder.get(); // Esto envía la solicitud al servidor y espera la respuesta.

        //Manejar la respuesta de la solicitud
        String respuesta = response.readEntity(String.class); // Lee el cuerpo de la respuesta. Se le pasa el parámetro String.class para indicar que se desea leer el cuerpo de la respuesta como una cadena de texto.
        client.close(); // Se utiliza para cerrar y liberar los recursos asociados al cliente.

        return respuesta; // Retorna la respuesta de la soliciud
    } catch (Exception e) {
         // Manejar excepciones
         e.printStackTrace(); // En caso de que se dispare una excepcion, se mostrara en consola.
         return "Error en la solicitud"; // Mensaje de error para el cuerpo rest.
    }
        
    }

   



}