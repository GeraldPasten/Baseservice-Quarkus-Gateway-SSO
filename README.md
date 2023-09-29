# SVR02-BUSSINES-GATEWAY
Este arquetipo fue desarrollado para banorte y apunta a ejemplificar cómo debe ser desarrollado un servicio gateway.Un servicio gateway o API gateway es un componente de software que actúa como punto de entrada único para las solicitudes de clientes hacia un sistema distribuido o una capa de servicios.

Esto bajo el contexto de Openshift Container Platform (OCP), un servicio gateway se refiere a un componente utilizado para gestionar y enrutar el tráfico de red hacia las aplicaciones desplegadas en el clúster de OpenShift.

Adicionalmente este arquetipo demuestra la incorporación de una capa de seguridad para este servicio gateway mediante Single Sign On (SSO), el cómo proteger nuestra puerta de entrada a la capa de servicio mediante tokens de seguridad.

# Contenido

- [x] Endpoints SOAP & REST
- [x] Consumo REST TO REST
- [x] Consumo SOAP TO REST
- [x] Consumo SOAP TO SOAP
- [x] Recibir y producir JSON
- [x] Despliegue en ocp / Comandos OC
- [x] Carpeta Openshift
- [x] Parametrizacion y Configuracion
- [x] Configuracion de Logs 
- [x] Manejo de excepciones
- [x] Junit Test

# Tecnologías utilizadas
Quarkus: Un framework de Java diseñado para aplicaciones nativas de la nube.
REST: Un estilo arquitectónico para construir servicios web escalables y fáciles de consumir.
SOAP: Proporciona un estándar para la estructura de los mensajes y la forma en que deben enviarse entre las aplicaciones.

# Configuración
La configuración de la aplicación se encuentra en el archivo application.properties en la carpeta resources. Aquí se pueden ajustar diversos aspectos, como la configuración de la base de datos, los logs y otras propiedades específicas de Quarkus.

# Conexion con RH SSO 
Configuracion para la conexion son RedHat Singles Sign On (RH SSO) mediante Open id Conect 

quarkus.oidc.auth-server-url => Especificar la URL del servidor de autenticación en un escenario de autenticación.
quarkus.oidc.client-id => Especificar el identificador del cliente (client ID) en un escenario de autenticación.
quarkus.oidc.credentials.secret => Especificar el secreto del cliente (client secret) en un escenario de autenticación.
quarkus.oidc.application-type=> Especificar el tipo de aplicacion que sera protegida en un escenario de autenticación.

# Manejo de logs
La configuración de logs se encuentra en el archivo application.properties. Aquí se pueden ajustar los niveles de log para diferentes paquetes y clases, así como configurar la salida de los logs.

Además, Camel proporciona su propio mecanismo de logging que se puede configurar mediante opciones específicas en las rutas.

# Manejo de excepciones
La aplicación muestra ejemplos de cómo manejar excepciones utilizando Camel. Se pueden agregar manejadores de excepciones personalizados en las rutas para capturar y manejar excepciones específicas según sea necesario.

# Pruebas JUnit 


# Configuraciones de ruteo para OpenShift
La carpeta openshift contiene el archivo route-config.yaml, que proporciona configuraciones de rutas para OpenShift. Estas configuraciones se pueden utilizar para exponer los puntos de acceso REST de la aplicación en un clúster de OpenShift.

# Comandos
A continuación se presentan algunos comandos útiles para utilizar la aplicación:

#### Ejecutar la aplicación en modo de desarrollo:

./mvnw compile quarkus:dev
Empaquetar y ejecutar la aplicación:

./mvnw package
java -jar target/quarkus-app/quarkus-run.jar
Crear un ejecutable nativo:

./mvnw package -Pnative
Ejecutar el ejecutable nativo en un contenedor:

./mvnw package -Pnative -Dquarkus.native.container-build=true

#### Ejecutar analisis Sonar
mvn clean verify sonar:sonar -Dsonar.test.junit  -Dsonar.projectKey=com.mx.banorte.services:baseservice-rest-databese-crud   -Dsonar.host.url=http://localhost:9000   -Dsonar.login=sqp_bc01d24be7dfd498fe42346cec4144f6619a3712