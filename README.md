# Taller Clientes y Servicios
## Descripción 
El siguiente Taller se desarrolló e implementó una arquitectura muy usada en la actualidad y es la del Cliente-Servidor, para lograr esto se realizarán una serie de ejercicios
de calentamiento, luego algunos retos avanzados.

## Prerrequisitos
Para la realización y ejecución tanto del programa como de las pruebas de este, se requieren ser instalados los siguientes programas:
* [Maven](https://maven.apache.org/). Herramienta que se encarga de estandarizar la estructura física de los proyectos de software, maneja dependencias (librerías) automáticamente desde repositorios y administra el flujo de vida de construcción de un software.
* [GIT](https://git-scm.com/). Sistema de control de versiones que almacena cambios sobre un archivo o un conjunto de archivos, permite recuperar versiones previas de esos archivos y permite otras cosas como el manejo de ramas (branches).

## Ejecución 
Para ejecutar el proyecto utilizando la herramienta Maven, nos dirigimos al directorio donde se encuentra alojado el proyecto, y dentro de este ejecutamos en un Shell o Símbolo del Sistema el siguiente comando:

```
mvn exec:java -Dexec.mainClass="edu.escuelaing.arem.packageExample.mainExample"
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
