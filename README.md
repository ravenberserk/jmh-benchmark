# JMH Benchmark

Ejemplo del uso de la librería **JMH** para la realización de benchmarks en *Java*. 

Para ello se propone como ejemplo la comparación del tiempo de ejecución de la obtención de un dato de un listado de elementos empleado un bucle **FOR** o iterando mediante **Stream**. 

## Como ejecutar el benchmark.

Para la ejecución del benchmark se dejará realizar los siguientes pasos:
* Compilar el proyecto, ejecutando el comando: `mvn clean package`.
* Ejecutar el **JAR** generado: `java -jar target/benchmarks.jar`