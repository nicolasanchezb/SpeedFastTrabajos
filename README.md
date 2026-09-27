# SpeedFast - Semana 6: Gestión de entregas con interfaz gráfica

**Autor:** Nicolas Sanchez Bustos  
**Carrera:** Analista Programador Computacional

Aplicación de escritorio desarrollada en Java Swing para registrar pedidos, consultar su estado, asignar repartidores y simular entregas concurrentes.

Este proyecto continúa el trabajo de las semanas anteriores y utiliza las clases `Pedido`, `PedidoComida`, `PedidoEncomienda`, `PedidoExpress`, `Repartidor` y `ZonaDeCarga`.

## Funcionalidades

- Registrar pedidos de comida, encomienda y tipo express.
- Validar ID, dirección y distancia antes de guardar.
- Evitar el registro de IDs duplicados.
- Mostrar los pedidos en una tabla con su tipo, distancia, repartidor, estado y tiempo estimado.
- Asignar un repartidor a un pedido pendiente.
- Iniciar una simulación de entregas con tres repartidores concurrentes.
- Actualizar la tabla para observar los cambios de estado.

## Estructura del proyecto

```text
src/
├── main/
│   └── Main.java
├── ui/
│   ├── VentanaPrincipal.java
│   ├── VentanaRegistroPedido.java
│   └── VentanaListaPedidos.java
├── service/
│   ├── GestorPedidos.java
│   └── ControladorDeEnvios.java
├── model/
│   ├── Pedido.java
│   ├── PedidoComida.java
│   ├── PedidoEncomienda.java
│   ├── PedidoExpress.java
│   ├── EstadoPedido.java
│   ├── Repartidor.java
│   └── ZonaDeCarga.java
├── interfaces/
│   ├── Cancelable.java
│   ├── Despachable.java
│   └── Rastreable.java
└── app/
    └── Main.java
```

`app.Main` conserva la demostración por consola de la semana anterior. La interfaz gráfica se inicia desde `main.Main`.

## Cómo ejecutar

1. Abre el proyecto en IntelliJ IDEA.
2. Verifica que el proyecto tenga configurado un JDK.
3. Ejecuta la clase `main.Main`.
4. En la ventana principal, selecciona **Registrar pedido**, **Listar pedidos** o **Iniciar entregas**.

## Uso de la aplicación

### Registrar un pedido

Ingresa un ID positivo, una dirección y una distancia mayor que cero. Después selecciona el tipo de pedido y pulsa **Guardar**. La aplicación mostrará una confirmación si el registro fue correcto.

### Consultar y asignar

Abre **Listar pedidos** para ver la tabla. Selecciona un pedido pendiente y pulsa **Asignar repartidor al seleccionado**. El botón **Refrescar** vuelve a cargar los datos de la tabla; mientras la ventana está abierta, también se actualiza automáticamente.

### Iniciar entregas

Pulsa **Iniciar entregas** en la ventana principal. Los repartidores procesarán los pedidos pendientes utilizando un grupo de tres hilos. Los estados permiten distinguir pedidos `PENDIENTE`, `EN_REPARTO` y `ENTREGADO`.

## Pedidos de ejemplo

Al iniciar la interfaz se cargan los pedidos de las semanas anteriores:

| ID | Tipo | Dirección | Distancia |
| --- | --- | --- | ---: |
| 101 | Comida | Avenida Alemania 450 | 4 km |
| 102 | Encomienda | Calle Independencia 820 | 6 km |
| 103 | Express | Avenida Pedro Montt 1200 | 8 km |
| 104 | Comida | Calle Los Robles 350 | 3 km |
| 105 | Encomienda | Avenida Francia 740 | 5 km |
| 106 | Express | Calle Simpson 225 | 2 km |

## Organización del código

- **`model`:** representa los pedidos, sus estados, los repartidores y la zona de carga.
- **`service.GestorPedidos`:** mantiene la lista compartida de pedidos, valida IDs duplicados e inicia las entregas.
- **`ui`:** contiene las ventanas Swing, los formularios, botones y la tabla.
- **`main.Main`:** carga los pedidos de ejemplo y abre la ventana principal.

La tabla utiliza `JTable` y `DefaultTableModel`. Las ventanas comparten una misma instancia de `GestorPedidos`, por lo que un pedido registrado puede verse desde la ventana de listado.

## Alcance actual

Los pedidos se mantienen en memoria mientras la aplicación está abierta. Al cerrarla, los pedidos registrados desde el formulario no se conservan. Los seis pedidos de ejemplo vuelven a crearse al iniciar el programa.
