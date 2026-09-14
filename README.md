# SpeedFast - Semana 5

## Sincronizando procesos en sistemas concurrentes

Proyecto desarrollado para la actividad formativa individual de la quinta semana de la asignatura de Programación. El sistema simula la coordinación de entregas de la empresa **SpeedFast**, donde varios repartidores trabajan de manera simultánea y acceden a una zona de carga compartida.

La solución utiliza programación concurrente y métodos sincronizados para impedir que dos repartidores retiren el mismo pedido.

## Objetivo

Implementar mecanismos de sincronización en Java para controlar el acceso concurrente a un recurso compartido, evitando condiciones de carrera y garantizando que cada pedido sea retirado y entregado por un único repartidor.

## Funcionalidades

- Registro de pedidos en una zona de carga compartida.
- Manejo de los estados `PENDIENTE`, `EN_REPARTO` y `ENTREGADO`.
- Ejecución simultánea de tres repartidores.
- Retiro sincronizado de pedidos desde la zona de carga.
- Simulación del tiempo de entrega mediante `Thread.sleep()`.
- Actualización del estado de cada pedido durante el proceso.
- Finalización controlada mediante `ExecutorService`.
- Confirmación en consola cuando todos los pedidos han sido entregados.

## Tecnologías utilizadas

- Java
- Programación orientada a objetos
- `Runnable`
- `ExecutorService`
- `synchronized`
- `Thread.sleep()`
- `ArrayList`
- IntelliJ IDEA
- JDK 25

## Estructura del proyecto

```text
semana 5
├── README.md
└── src
    ├── app
    │   └── Main.java
    ├── interfaces
    │   ├── Cancelable.java
    │   ├── Despachable.java
    │   └── Rastreable.java
    ├── model
    │   ├── EstadoPedido.java
    │   ├── Pedido.java
    │   ├── PedidoComida.java
    │   ├── PedidoEncomienda.java
    │   ├── PedidoExpress.java
    │   ├── Repartidor.java
    │   └── ZonaDeCarga.java
    └── service
        └── ControladorDeEnvios.java
```

## Clases principales

### `Pedido`

Clase abstracta que contiene los datos comunes de los pedidos, como identificador, dirección de entrega, distancia, repartidor asignado y estado. Cada pedido comienza con el estado `PENDIENTE`.

### `EstadoPedido`

Enumeración que define los estados válidos de un pedido:

- `PENDIENTE`: el pedido se encuentra esperando en la zona de carga.
- `EN_REPARTO`: un repartidor retiró el pedido y está realizando la entrega.
- `ENTREGADO`: la entrega fue completada correctamente.

### `ZonaDeCarga`

Representa el recurso compartido del sistema. Almacena los pedidos pendientes y utiliza métodos `synchronized` para controlar el acceso a la lista.

El método `retirarPedido()` ejecuta de forma atómica las siguientes acciones:

1. Busca un pedido pendiente.
2. Cambia su estado a `EN_REPARTO`.
3. Lo elimina de la zona de carga.
4. Lo entrega al repartidor que realizó la solicitud.

Esto evita que dos repartidores retiren el mismo pedido.

### `Repartidor`

Implementa la interfaz `Runnable`. Cada repartidor trabaja de forma independiente, retira pedidos de la zona compartida, simula la entrega y cambia el estado a `ENTREGADO`.

### `Main`

Crea una zona de carga, agrega seis pedidos e inicia tres repartidores llamados Juan, María y Alexis. Los repartidores se ejecutan utilizando un `ExecutorService` con tres hilos.

El método `awaitTermination()` permite que el hilo principal espere hasta que todas las entregas hayan finalizado.

## Funcionamiento de la sincronización

Aunque los repartidores se ejecutan simultáneamente, el método sincronizado de la zona de carga permite que solamente un hilo retire un pedido a la vez. Cuando un repartidor termina de retirar el pedido, el acceso queda disponible para otro hilo.

Los mensajes pueden aparecer en un orden diferente en cada ejecución, ya que el sistema operativo decide qué hilo se ejecuta primero. Sin embargo, cada pedido debe aparecer una sola vez como entregado.

## Ejemplo de salida

```text
==================================
       SISTEMA SPEEDFAST
==================================
Pedido 101 agregado a la zona de carga.
Pedido 102 agregado a la zona de carga.
Pedido 103 agregado a la zona de carga.
Juan retiró el pedido 101 - Estado: EN_REPARTO
María retiró el pedido 102 - Estado: EN_REPARTO
Alexis retiró el pedido 103 - Estado: EN_REPARTO
Juan entregó el pedido 101 - Estado: ENTREGADO
María entregó el pedido 102 - Estado: ENTREGADO
Alexis entregó el pedido 103 - Estado: ENTREGADO
==================================
Todos los pedidos han sido entregados correctamente
==================================
```

El orden de los repartidores y pedidos puede cambiar en cada ejecución debido al trabajo concurrente.

## Cómo ejecutar el proyecto

1. Abrir el proyecto en IntelliJ IDEA.
2. Comprobar que el proyecto tenga configurado un JDK compatible.
3. Abrir `src/app/Main.java`.
4. Ejecutar el método `main()`.
5. Revisar en la consola el retiro y la entrega de los pedidos.

## Resultado

El sistema permite que tres repartidores procesen pedidos en paralelo sin producir entregas duplicadas. La sincronización aplicada en la zona de carga protege el recurso compartido y mantiene la integridad de los estados de los pedidos.

## Autor

**Nicolas Sanchez B.**  
Carrera: Analista Programador Computacional
