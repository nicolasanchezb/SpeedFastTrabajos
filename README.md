# SpeedFast – Semana 4

## Ejecutando tareas en paralelo con hilos en Java

Proyecto desarrollado para simular el proceso de entrega de pedidos de la empresa **SpeedFast**. En esta cuarta semana se incorporó programación concurrente mediante `Runnable`, `Thread.sleep()` y `ExecutorService`, permitiendo que varios repartidores realicen entregas simultáneamente.

## Objetivo

Aplicar programación multihilo en Java dentro de una estructura orientada a objetos. Cada repartidor se ejecuta como una tarea independiente, recorre secuencialmente su lista de pedidos y muestra en consola el avance de sus entregas.

## Funcionalidades

- Registro de pedidos de comida, encomienda y express.
- Cálculo diferenciado del tiempo estimado según el tipo de pedido.
- Creación de tres repartidores con dos pedidos asignados a cada uno.
- Ejecución simultánea de los repartidores.
- Procesamiento secuencial de los pedidos de cada repartidor.
- Simulación de las entregas mediante pausas aleatorias.
- Visualización del progreso y finalización de cada entrega en consola.
- Espera del programa principal hasta que todos los repartidores terminen.

## Estructura del proyecto

```text
src/
├── app/
│   └── Main.java
├── model/
│   ├── Pedido.java
│   ├── PedidoComida.java
│   ├── PedidoEncomienda.java
│   ├── PedidoExpress.java
│   └── Repartidor.java
├── interfaces/
│   ├── Despachable.java
│   ├── Cancelable.java
│   └── Rastreable.java
└── service/
    └── ControladorDeEnvios.java
```

## Descripción de las clases principales

### `Pedido`

Clase abstracta que contiene los atributos comunes de los pedidos:

- `idPedido`
- `direccionEntrega`
- `distanciaKm`
- `repartidorAsignado`

También define métodos como `mostrarResumen()`, `calcularTiempoEntrega()`, `asignarRepartidor()`, `obtenerTipoEntrega()` y `obtenerFactoresDuracion()`.

### Tipos de pedido

- `PedidoComida`: calcula 15 minutos base más 2 minutos por kilómetro.
- `PedidoEncomienda`: calcula 20 minutos base más 1,5 minutos por kilómetro.
- `PedidoExpress`: calcula 10 minutos y agrega 5 minutos cuando la distancia supera los 5 kilómetros.

### `Repartidor`

Implementa la interfaz `Runnable`. Cada objeto repartidor mantiene una lista de pedidos y, dentro de su método `run()`, realiza las siguientes acciones:

1. Informa el inicio de su jornada.
2. Recorre secuencialmente sus pedidos asignados.
3. Informa qué pedido está entregando.
4. Simula el proceso mediante `Thread.sleep()` con una duración aleatoria.
5. Informa la finalización de cada pedido.
6. Comunica cuando termina todas sus entregas.

### `Main`

Crea seis pedidos y tres repartidores: Juan, María y Alexis. A cada repartidor se le asignan dos pedidos. Las tareas se envían a un grupo de tres hilos mediante `ExecutorService`.

El método `shutdown()` impide el ingreso de nuevas tareas y `awaitTermination()` mantiene la simulación en ejecución hasta que todos los repartidores finalizan.

## Conceptos aplicados

- Programación orientada a objetos.
- Herencia y clases abstractas.
- Polimorfismo y sobrescritura de métodos.
- Interfaces.
- Colecciones con `ArrayList` y `List`.
- Implementación de `Runnable`.
- Ejecución concurrente con `ExecutorService`.
- Pausas con `Thread.sleep()`.
- Tiempos aleatorios con `ThreadLocalRandom`.
- Manejo de `InterruptedException`.

## Ejemplo de ejecución

```text
==================================
   SIMULACIÓN DE ENTREGAS
==================================
Juan comenzó su jornada de entregas.
María comenzó su jornada de entregas.
Alexis comenzó su jornada de entregas.
Juan está entregando el pedido 101 en Avenida Alemania 450
María está entregando el pedido 103 en Calle Independencia 820
Alexis está entregando el pedido 105 en Avenida Pedro Montt 1200
...
==================================
TODAS LAS ENTREGAS FUERON COMPLETADAS
==================================
```

El orden de los mensajes puede cambiar en cada ejecución, debido a que los repartidores trabajan concurrentemente.

## Requisitos

- IntelliJ IDEA.
- Java Development Kit (JDK) 25 o una versión compatible.

## Instrucciones de ejecución

1. Abrir el proyecto en IntelliJ IDEA.
2. Verificar que el JDK esté configurado correctamente.
3. Abrir la clase `Main`, ubicada en el paquete `app`.
4. Ejecutar el método `main()`.
5. Observar en consola el avance simultáneo de los repartidores.

## Autor

**Nicolas Sanchez B.**  
Carrera: Analista Programador Computacional

Proyecto funcional y ejecutado correctamente con código de salida `0`.
