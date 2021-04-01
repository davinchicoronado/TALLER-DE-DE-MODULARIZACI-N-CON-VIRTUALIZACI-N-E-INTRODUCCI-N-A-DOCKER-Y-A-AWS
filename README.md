# Taller Dockers y Aws
## Descripción 
El siguiente Taller se desarrolló   dos proyectos distintos que se comunican mediante peticiones HTTP, con el objetivo de almacenar información de un usuario 
estos seran almacenados en containers Dockers que de manera similar a las maquinas virtuales pueden virtualizar, pero en vez de hardware , los contenedores virtualizaran el sistema operativo de un servidor. Luego de mostrar y describir como desplegarlo localmente, se exponen muestras de como desplegarlo en una maquina Aws.

## Prerrequisitos
Para la realización y ejecución tanto del programa como de las pruebas de este, se requieren ser instalados los siguientes programas:
* [Maven](https://maven.apache.org/). Herramienta que se encarga de estandarizar la estructura física de los proyectos de software, maneja dependencias (librerías) automáticamente desde repositorios y administra el flujo de vida de construcción de un software.
* [GIT](https://git-scm.com/). Sistema de control de versiones que almacena cambios sobre un archivo o un conjunto de archivos, permite recuperar versiones previas de esos archivos y permite otras cosas como el manejo de ramas (branches).
* [Docker](https://www.docker.com). Docker, es una tecnología de creación de contenedores que permite la creación y el uso de contenedores de Linux®. La comunidad open source Docker trabaja para mejorar estas tecnologías a fin de beneficiar a todos los usuarios de forma gratuita.

## Ejecución 
Para ejecutar el proyecto localmente, utilizando la herramienta Maven, nos dirigimos al directorios donde se encuentran alojados los proyectos, y dentro de este ejecutamos en un Shell o Símbolo del Sistema los siguientes comandos:

```
mvn exec:java -Dexec.mainClass="edu.escuelaing.arem.app.SparkWebApp"
mvn exec:java  -Dexec.mainClass="edu.escuelaing.arem.api.SparkWebApi"
```
## Implementación

### Calentamiento
#### Ejercicio1
Este se desarrollo en la clase URLParser es muy simple pero hay que saber como crear o usar una URL para poder obtener todos sus atributos.

#### Ejercicio2
Este se desarrollo en la clase URLReader que lee una URL y toda la información que pueda obtener la guardará en un archivo llamado resultado.html.


#### Ejercicio3
La clase EchoServer por medio de sockets recibira enteros y devolverá su cuadrado, y por la clase EchoClient leerá enteros y estos enteros se los enviará a EchoServer retornandole el cuadrado del número luego EchoClient recibirá este valor  y lo imprimirá. Para poder realizar lo anteriormente descrito deberemos ejecutar las dos clases simultaneamente.

  ##  Reto 1
