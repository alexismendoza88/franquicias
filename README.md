<H2>Prerequsitos</H2>

*Instalar Docker

*Instalar Java jdk 17

*Tu IDE preferido para java (NetBEANTS)

<H2>Pasos a seguir</H2>

1.Configurar el proyecto con Spring Boot, WebFlux y MongoDB.

2.Definir los modelos: Franquicia, Sucursal, Producto.

3.Crear los repositorios reactivos con Spring Data MongoDB.

4.Implementar los servicios con programación reactiva.

5.Exponer los endpoints en un controlador reactivo.

6.Empaquetar con Docker.



<H2>Prerequsitos para desplegar </H2>


1.Descargar la imagen de mongodb para docker (mongodb/mongodb-community-server)
comando: "docker pull mongodb/mongodb-community-server:latest"

2.Terminado paso 1 crear docker dockerfile en franquicias\src (en repositorio se ecnuentra ya estructurado el archivo)
comando : ejeuctar "docker build." (abrir comando en el folder. Donde esta ubicado dockerfile "franquicias\src")

3.Terminado paso 2  crear archivo docker-compose.yml en en franquicias\src (en repositorio se ecnuentra ya estructurado el archivo)
comando: ejeuctar "docker-compose up" (abrir comando en el folder. Donde esta ubicado dockerfile "franquicias\src")

Nota importante:"Recuerda que los datos de como puerto y nombre  de basede datos para mongo deben ser los mismos que estan configurados en franquicias\src\main\resources\application.properties"

<H2>Herramientas de pruebas </H2>

*Para probar los endpoints utiliza herramientas como Postman,Insomnia

<h2>Estructura de los Endpoints</h2>

Franquicias

POST /api/franquicias → Crear una franquicia.

PUT  /api/franquicias/{id}/nombre → Actualizar el nombre de una franquicia.

GET /api/franquicias/{id}/max-stock → Obtener el producto con más stock por sucursal en una franquicia.

Sucursales

POST /api/franquicias/{franquiciaId}/sucursales → Agregar una sucursal a una franquicia.

PUT /api/franquicias/{franquiciaId}/sucursales/{sucursalId}/nombre → Actualizar el nombre de una sucursal.

Productos

POST /api/franquicias/{franquiciaId}/sucursales/{sucursalId}/productos → Agregar un producto a una sucursal.

PUT /api/franquicias/{franquiciaId}/sucursales/{sucursalId}/productos/{productoId} → Actualizar el nombre de un producto.

PUT /api/franquicias/{franquiciaId}/sucursales/{sucursalId}/productos/{productoId}/stock → Modificar el stock de un producto.




