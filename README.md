<H2>Prerequsitos</H2>

*Instalar Docker

*Instalar Java jdk 17

*Tu IDE prferido para java (NetBEANTS)

<H2>Paos a seguir</H2>

1.Configurar el proyecto con Spring Boot, WebFlux y MongoDB.

2.Definir los modelos: Franquicia, Sucursal, Producto.

3.Crear los repositorios reactivos con Spring Data MongoDB.

4.Implementar los servicios con programación reactiva.

5.Exponer los endpoints en un controlador reactivo.

6.Empaquetar con Docker.



<H2>Prerequsitos para desplegar </H2>


1.Descargar la imagen de mongodb para docker (mongodb/mongodb-community-server)
comando: docker pull mongodb/mongodb-community-server:latest 

2.termiando paso 1 crear docker dockerfile en franquicias\src (en repositorio se ecnuentra ya estructurado el archivo)
comando : ejeuctar "docker build." (abrir comando en el foder donde esta ubicado dockerfile "franquicias\src")

3.terminado paso 2  crear archivo docker-compose.yml en en franquicias\src (en repositorio se ecnuentra ya estructurado el archivo)
comando: ejeuctar "docker-compose up2 (abrir comando en el foder donde esta ubicado dockerfile "franquicias\src")


<H2>Herramientas de pruebas </H2>

*Para probar lso endpoitns utilzia herramienats como Postman,Insomnia

<h2>Estructura de los Endpoints</h2>



