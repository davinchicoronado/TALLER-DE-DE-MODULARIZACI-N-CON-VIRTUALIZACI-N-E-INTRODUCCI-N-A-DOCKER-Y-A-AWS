# Taller Dockers y Aws
## Descripción 
El siguiente Taller se desarrollaron   dos proyectos distintos que se comunican mediante peticiones HTTP, con el objetivo de almacenar información de un usuario 
estos seran almacenados en containers Dockers que de manera similar a las maquinas virtuales pueden virtualizar, pero en vez de hardware , los contenedores virtualizaran el sistema operativo de un servidor. Luego de mostrar y describir como desplegarlo localmente, se exponen muestras de como desplegarlo en una maquina Aws.

## Prerrequisitos
Para la realización y ejecución tanto del programa como de las pruebas de este, se requieren ser instalados los siguientes programas:
* [Maven](https://maven.apache.org/). Herramienta que se encarga de estandarizar la estructura física de los proyectos de software, maneja dependencias (librerías) automáticamente desde repositorios y administra el flujo de vida de construcción de un software.
* [GIT](https://git-scm.com/). Sistema de control de versiones que almacena cambios sobre un archivo o un conjunto de archivos, permite recuperar versiones previas de esos archivos y permite otras cosas como el manejo de ramas (branches).
* [Docker](https://www.docker.com). Docker, es una tecnología de creación de contenedores que permite la creación y el uso de contenedores de Linux®. La comunidad open source Docker trabaja para mejorar estas tecnologías a fin de beneficiar a todos los usuarios de forma gratuita.

## Ejecución 
Para ejecutar los proyectos localmente, utilizando la herramienta Maven, nos dirigimos al directorios donde se encuentran alojados los proyectos, y dentro de estos ejecutamos en un Shell o Símbolo del Sistema los siguientes comandos:

```
mvn exec:java -Dexec.mainClass="edu.escuelaing.arem.app.SparkWebApp"
mvn exec:java  -Dexec.mainClass="edu.escuelaing.arem.api.SparkWebApi"
```
Luego con el siguiente comando, en cada una de las lineas de comandos de los proyectos crearemos las imagenes, y los containers haciendo referencia a estas, ademas de crear una red privada con una dirección ip para cada container, y permitir la comunicación entre ellos. (En los archivos docker-compose se puede ver con mas detalle como fueron asignadas estas direcciones).
```
docker-compose up -d
```
Para crear containers logService mas adelante se explicará como crearlos, ya que para desplegarlo en una maquina Aws es el mismo proceso.

## Implementación

Del lado del cliente tenemos el proyecto App-Lb-RoundRobin y como primera instancia existe la clase SparkWebApp que proporcionará la vista al usuario, y esta consume servicios de una APIrest llamada APIServiceRest que como funcion tiene, es hacer peticiones http del lado del cliente.
Estas peticiones las realiza con un conjunto de urls las cuales permiten hallar los logServices y en que puertos encontrarlos.
 <p align="center">
    <img src="https://github.com/davinchicoronado/TALLER-DE-DE-MODULARIZACI-N-CON-VIRTUALIZACI-N-E-INTRODUCCI-N-A-DOCKER-Y-A-AWS/blob/master/Img/conectionOthers.png?raw=true" alt="Sublime's custom image"/>
  </p>

