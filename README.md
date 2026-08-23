# SpeedFast

SpeedFast es una aplicación desarrollada en Java que representa el funcionamiento básico de una empresa de entregas. El sistema permite registrar diferentes tipos de pedidos y calcular sus tiempos estimados de entrega mediante clases abstractas, herencia, sobrescritura y polimorfismo.

## Información académica

- **Actividad:** Cálculo polimórfico mediante clases abstractas
- **Semana:** 2
- **Carrera:** Analista Programador Computacional
- **Estudiante:** Nicolas Sanchez Bustos
- **Lenguaje:** Java
- **IDE:** IntelliJ IDEA
- **JDK:** 25

## Objetivo del proyecto

El objetivo del proyecto es desarrollar una jerarquía de clases que permita representar diferentes tipos de pedidos.

Cada pedido incluye la siguiente información:

- Identificador del pedido.
- Dirección de entrega.
- Distancia en kilómetros.
- Tipo de entrega.
- Factores que afectan su duración.
- Tiempo estimado de entrega.

Cada tipo de pedido implementa una fórmula diferente para calcular su tiempo estimado.

## Estructura del proyecto

```text
SpeedFast
└── src
    ├── app
    │   └── Main.java
    │
    └── model
        ├── Pedido.java
        ├── PedidoComida.java
        ├── PedidoEncomienda.java
        └── PedidoExpress.java
```

## Organización de los paquetes

### Paquete `app`

Contiene la clase principal del programa:

- `Main.java`

Esta clase crea los pedidos, ejecuta los métodos y muestra los resultados en la consola.

### Paquete `model`

Contiene las clases relacionadas con el modelo de los pedidos:

- `Pedido.java`
- `PedidoComida.java`
- `PedidoEncomienda.java`
- `PedidoExpress.java`

## Descripción de las clases

### Pedido

`Pedido` es una clase abstracta que contiene la información común de todos los pedidos.

Sus atributos son:

- `idPedido`: identificador único del pedido.
- `direccionEntrega`: dirección en la que se realizará la entrega.
- `distanciaKm`: distancia de la entrega expresada en kilómetros.

También contiene el método implementado `mostrarResumen()`, encargado de mostrar los datos principales del pedido.

La clase declara los siguientes métodos abstractos:

- `calcularTiempoEntrega()`
- `obtenerTipoEntrega()`
- `obtenerFactoresDuracion()`

Estos métodos deben ser implementados por cada clase derivada.

### PedidoComida

Representa un pedido de comida.

Su tiempo estimado se calcula mediante la siguiente fórmula:

```text
Tiempo = 15 minutos + 2 minutos por cada kilómetro
```

Ejemplo para una distancia de 4 kilómetros:

```text
Tiempo = 15 + (2 × 4)
Tiempo = 23 minutos
```

### PedidoEncomienda

Representa la entrega de una encomienda.

Su tiempo estimado se calcula mediante la siguiente fórmula:

```text
Tiempo = 20 minutos + 1,5 minutos por cada kilómetro
```

El resultado se ajusta a un número entero mediante `Math.round()`.

Ejemplo para una distancia de 5 kilómetros:

```text
Tiempo = 20 + (1,5 × 5)
Tiempo = 27,5
Tiempo redondeado = 28 minutos
```

### PedidoExpress

Representa un pedido de entrega express.

El tiempo base es de 10 minutos. Si la distancia es superior a 5 kilómetros, se agregan 5 minutos adicionales.

```text
Distancia de hasta 5 km: 10 minutos
Distancia superior a 5 km: 15 minutos
```

Ejemplo para una distancia de 8 kilómetros:

```text
Tiempo base = 10 minutos
Tiempo adicional = 5 minutos
Tiempo total = 15 minutos
```

### Main

`Main` es el punto de entrada de la aplicación.

Esta clase realiza las siguientes acciones:

- Crea un objeto de tipo `PedidoComida`.
- Crea un objeto de tipo `PedidoEncomienda`.
- Crea un objeto de tipo `PedidoExpress`.
- Almacena los objetos en un arreglo de tipo `Pedido`.
- Recorre el arreglo mediante un ciclo `for`.
- Ejecuta `mostrarResumen()` para cada pedido.
- Ejecuta `calcularTiempoEntrega()` para cada pedido.
- Presenta una comparación final de los tiempos.

## Conceptos de programación aplicados

### Abstracción

La clase `Pedido` se declara como abstracta:

```java
public abstract class Pedido
```

Esto significa que no se pueden crear objetos directamente a partir de ella. Su función es proporcionar una estructura común para las clases derivadas.

### Herencia

Las clases específicas heredan de la clase `Pedido` mediante la palabra reservada `extends`.

Ejemplo:

```java
public class PedidoComida extends Pedido
```

Gracias a la herencia, las clases derivadas reciben los atributos y métodos definidos en la clase abstracta.

### Sobrescritura de métodos

Cada clase derivada implementa su propia versión del método `calcularTiempoEntrega()`.

Para indicar que un método está siendo sobrescrito se utiliza la anotación:

```java
@Override
```

Esto permite que cada tipo de pedido tenga una lógica diferente para calcular su tiempo.

### Polimorfismo

Los objetos de las clases derivadas se almacenan utilizando referencias de tipo `Pedido`.

```java
Pedido pedidoComida = new PedidoComida(
        101,
        "Avenida Alemania 450",
        4
);
```

También se utiliza un arreglo polimórfico:

```java
Pedido[] pedidos = {
        pedidoComida,
        pedidoEncomienda,
        pedidoExpress
};
```

Esto permite recorrer y procesar diferentes tipos de pedidos utilizando una misma estructura.

### Encapsulamiento

Los atributos comunes son administrados por la clase `Pedido`.

Para consultar el identificador desde la clase `Main`, se utiliza el método:

```java
public int getIdPedido() {
    return idPedido;
}
```

### Estructura condicional

La clase `PedidoExpress` utiliza una estructura `if` para comprobar si la distancia supera los 5 kilómetros.

```java
if (distanciaKm > 5) {
    tiempo = tiempo + 5;
}
```

### Estructura repetitiva

La clase `Main` utiliza un ciclo `for` mejorado para recorrer el arreglo de pedidos.

```java
for (Pedido pedido : pedidos) {
    pedido.mostrarResumen();
}
```

## Ejemplo de ejecución

```text
==================================
       SISTEMA SPEEDFAST
==================================
ID del pedido: 101
Dirección de entrega: Avenida Alemania 450
Distancia: 4.0 km
Tipo de entrega: Pedido de comida
Factores que afectan su duración: 15 minutos base más 2 minutos por cada kilómetro
Tiempo estimado de entrega: 23 minutos
----------------------------------
ID del pedido: 102
Dirección de entrega: Calle Independencia 820
Distancia: 5.0 km
Tipo de entrega: Pedido de encomienda
Factores que afectan su duración: 20 minutos base más 1,5 minutos por cada kilómetro
Tiempo estimado de entrega: 28 minutos
----------------------------------
ID del pedido: 103
Dirección de entrega: Avenida Pedro Montt 1200
Distancia: 8.0 km
Tipo de entrega: Pedido express
Factores que afectan su duración: 10 minutos base más 5 minutos adicionales por superar los 5 kilómetros
Tiempo estimado de entrega: 15 minutos
----------------------------------

COMPARACIÓN DE TIEMPOS
----------------------------------
Pedido 101 | Pedido de comida | 23 minutos
Pedido 102 | Pedido de encomienda | 28 minutos
Pedido 103 | Pedido express | 15 minutos
```

## Requisitos

Para ejecutar el proyecto se necesita:

- IntelliJ IDEA.
- Java Development Kit, JDK 25 o compatible.
- Git, en caso de utilizar el control de versiones.
- Una cuenta de GitHub para publicar el repositorio.

## Instrucciones de ejecución

1. Descargar o clonar el repositorio.
2. Abrir IntelliJ IDEA.
3. Seleccionar la opción `File`.
4. Seleccionar `Open`.
5. Buscar y abrir la carpeta del proyecto `SpeedFast`.
6. Verificar que el JDK esté configurado correctamente.
7. Abrir el archivo `src/app/Main.java`.
8. Presionar el botón verde de ejecución.
9. Revisar los resultados en la consola.

## Actualización de la semana 2

Durante la semana 2 se realizaron los siguientes cambios:

- Se creó la clase abstracta `Pedido`.
- Se agregaron los atributos comunes de los pedidos.
- Se implementó el método `mostrarResumen()`.
- Se creó el método abstracto `calcularTiempoEntrega()`.
- Se creó la clase `PedidoComida`.
- Se creó la clase `PedidoEncomienda`.
- Se creó la clase `PedidoExpress`.
- Se implementaron fórmulas diferenciadas para calcular los tiempos.
- Se incorporó el tipo de entrega de cada pedido.
- Se incorporaron los factores que afectan la duración.
- Se utilizó `Math.round()` para ajustar el tiempo de las encomiendas.
- Se utilizó una estructura `if` en los pedidos express.
- Se implementó polimorfismo mediante un arreglo de tipo `Pedido`.
- Se organizó el proyecto en los paquetes `app` y `model`.
- Se actualizó la salida de la aplicación para comparar los tiempos.

## Control de versiones

El proyecto utiliza Git y GitHub para registrar las actualizaciones realizadas durante las distintas semanas de desarrollo.

Mensaje de commit recomendado para esta actualización:

```text
Semana 2: implementación de clase abstracta Pedido y cálculo de tiempos
```

## Entrega

Para entregar la actividad se deben proporcionar los siguientes elementos:

- Enlace público del repositorio de GitHub.
- Proyecto completo comprimido en formato `.zip` o `.rar`.
- Código correctamente organizado en los paquetes `app` y `model`.
- Repositorio actualizado con los commits correspondientes a la semana 2.

## Autor

**Nicolas Sanchez Bustos**  
Estudiante de Analista Programador Computacional
