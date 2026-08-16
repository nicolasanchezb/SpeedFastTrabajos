# SpeedFast

Sistema de gestión de pedidos para una empresa de reparto a domicilio, desarrollado en **Java** como parte de una actividad formativa sobre **sobrecarga y sobreescritura en clases derivadas**.

## 📌 Descripción

**SpeedFast** es un prototipo de sistema orientado a objetos que permite representar diferentes tipos de pedidos y la asignación de repartidores según las características de cada servicio.

El sistema contempla tres tipos de pedidos:

* 🍔 **Pedido de Comida:** requiere un repartidor con mochila térmica.
* 📦 **Pedido de Encomienda:** requiere validación del peso y embalaje.
* 🛒 **Pedido Express:** requiere un repartidor cercano y con disponibilidad inmediata.

Además, se incorpora una situación especial para pedidos Express, donde un repartidor cercano puede tener espacio disponible para realizar un **doble pedido**.

## 🎯 Objetivo

El objetivo principal es aplicar conceptos fundamentales de la programación orientada a objetos:

* Herencia.
* Polimorfismo.
* Sobrecarga de métodos.
* Sobreescritura de métodos.
* Uso de la anotación `@Override`.
* Creación de objetos mediante clases derivadas.

## 🏗️ Estructura del proyecto

```text
SpeedFast/
└── src/
    ├── Pedido.java
    ├── PedidoComida.java
    ├── PedidoEncomienda.java
    ├── PedidoExpress.java
    └── Main.java
```

### 📄 Descripción de las clases

#### `Pedido.java`

Es la clase base del sistema.

Contiene los atributos generales:

* `idPedido`
* `direccionEntrega`
* `tipoPedido`

También define las diferentes versiones del método `asignarRepartidor()`.

#### `PedidoComida.java`

Hereda de `Pedido` y representa los pedidos provenientes de restaurantes.

Su lógica considera que el repartidor debe contar con una **mochila térmica**.

#### `PedidoEncomienda.java`

Hereda de `Pedido` y representa documentos o paquetes.

Su lógica considera la **validación del peso y las condiciones del embalaje**.

#### `PedidoExpress.java`

Hereda de `Pedido` y representa compras realizadas en supermercados o farmacias.

Su lógica considera la **cercanía del repartidor, disponibilidad inmediata y espacio para realizar un doble pedido**.

#### `Main.java`

Contiene el método `main()` y permite probar el funcionamiento del sistema.

Se crean diferentes pedidos y se ejecutan los métodos sobrecargados y sobrescritos.

## 🔄 Polimorfismo

El proyecto utiliza polimorfismo mediante la redefinición del método:

```java
public void asignarRepartidor()
```

Cada clase derivada entrega un comportamiento diferente.

### Pedido de comida

```text
Buscando repartidor con mochila térmica.
```

### Pedido de encomienda

```text
Validando peso y condiciones del embalaje.
```

### Pedido Express

```text
Buscando al repartidor más cercano.
Verificando disponibilidad inmediata.
```

## 🔁 Sobrecarga de métodos

El proyecto implementa diferentes versiones del método `asignarRepartidor()`:

```java
asignarRepartidor()
```

```java
asignarRepartidor(String nombreRepartidor)
```

```java
asignarRepartidor(String nombreRepartidor, String calle)
```

Cada versión posee una firma diferente y permite realizar distintas operaciones.

Por ejemplo:

```java
expressCercano.asignarRepartidor(
        "Juan",
        "Av. Providencia"
);
```

Esta versión permite indicar el nombre del repartidor y la calle donde se encuentra.

## 👥 Ejemplos utilizados

| Pedido | Tipo       | Repartidor | Situación                               |
| ------ | ---------- | ---------- | --------------------------------------- |
| 101    | Comida     | Carlos     | Requiere mochila térmica                |
| 102    | Encomienda | Javier     | Validación de peso y embalaje           |
| 103    | Express    | Felipe     | Repartidor cercano y disponible         |
| 104    | Express    | Juan       | Cercano y con espacio para doble pedido |

## 🖥️ Tecnologías utilizadas

* **Java**
* **IntelliJ IDEA**
* **JDK 25**
* **Git**
* **GitHub**

## ▶️ Ejecución del proyecto

### 1. Clonar el repositorio

Desde una terminal:

```bash
git clone URL_DEL_REPOSITORIO
```

### 2. Abrir el proyecto

Abrir la carpeta del proyecto utilizando **IntelliJ IDEA**.

### 3. Verificar el JDK

Configurar el proyecto para utilizar una versión compatible de Java.

Para este proyecto se utilizó:

```text
JDK 25
```

### 4. Ejecutar el programa

Abrir:

```text
src/Main.java
```

y ejecutar el método:

```java
public static void main(String[] args)
```

## 📋 Salida esperada

Al ejecutar el programa se mostrarán mensajes similares a:

```text
====================================
          SISTEMA SPEEDFAST
====================================

--- SOBRESCRITURA ---

Pedido de comida #101
Buscando repartidor con mochila térmica.
Pedido listo para ser asignado.

Pedido de encomienda #102
Validando peso y condiciones del embalaje.
Buscando repartidor disponible.

Pedido Express #103
Buscando al repartidor más cercano.
Verificando disponibilidad inmediata.

--- SOBRECARGA ---

Pedido de comida #101
Repartidor asignado: Carlos
Validación: el repartidor debe contar con mochila térmica.

Pedido de encomienda #102
Repartidor asignado: Javier
Validación: peso y embalaje de la encomienda verificados.

Pedido Express #103
Repartidor asignado: Felipe
Validación: repartidor cercano y con disponibilidad inmediata.

Pedido Express #104
Repartidor: Juan
Ubicación: cercano a Av. Providencia
Validación: repartidor cercano.
Espacio disponible para realizar un doble pedido.

====================================
           FIN DEL SISTEMA
====================================
```

## 📚 Conceptos aplicados

Este proyecto permite demostrar los siguientes conceptos de programación orientada a objetos:

**Herencia:** las clases `PedidoComida`, `PedidoEncomienda` y `PedidoExpress` heredan atributos y comportamientos de `Pedido`.

**Sobreescritura:** las clases derivadas modifican el comportamiento del método `asignarRepartidor()` utilizando `@Override`.

**Sobrecarga:** se utilizan diferentes versiones de `asignarRepartidor()` con distintos parámetros.

**Polimorfismo:** una misma operación puede presentar comportamientos diferentes dependiendo del tipo de pedido.

## 👨‍💻 Autor

**Nicolas Sanchez Bustos**

Estudiante de **Analista Programador Computacional**.

Proyecto desarrollado con fines académicos.

## 📌 Estado del proyecto

**Completado — Actividad formativa Semana 1**

El proyecto cumple con la implementación solicitada de:

* Clase base `Pedido`.
* Tres clases derivadas.
* Sobreescritura de métodos.
* Sobrecarga de métodos.
* Pruebas mediante `Main`.
* Mensajes informativos en consola.
