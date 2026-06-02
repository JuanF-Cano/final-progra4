# Documentación del aplicativo VetCare

## 1. Descripción general

Este proyecto es una aplicación de gestión veterinaria diseñada para modelar entidades básicas de una clínica de mascotas y consumir APIs públicas de razas de perros y gatos. Incluye:

- Un modelo de datos para animales, citas, propietarios y veterinarios.
- Una interfaz para animales vacunables.
- Servicios de consulta de razas a través de APIs REST externas.
- Conexión a una base de datos MySQL.

El código está escrito en Java y utiliza la API HTTP nativa (`java.net.http.HttpClient`), por lo que requiere Java 11 o superior.

## 2. Estructura del proyecto

```
final_progra4/
├── dao/
│   └── Conexion.java
├── interfaces/
│   └── Vacunable.java
├── modelo/
│   ├── Animal.java
│   ├── Cita.java
│   ├── Dueño.java
│   ├── Gato.java
│   ├── Perro.java
│   └── Veterinario.java
├── servicios/
│   ├── CatApiService.java
│   └── DogApiService.java
└── documentacion.md
```

## 3. Paquetes y responsabilidades

- `dao`: Contiene la clase encargada de gestionar la conexión con la base de datos MySQL.
- `interfaces`: Define el contrato `Vacunable` para las clases que pueden recibir vacunas.
- `modelo`: Define las entidades del dominio de la aplicación.
- `servicios`: Contiene servicios para consumir APIs externas que retornan datos de razas de perros y gatos.

## 4. Descripción de clases e interfaces

### 4.1 `dao.Conexion`

Esta clase centraliza la configuración de conexión a la base de datos MySQL.

- `URL`: Cadena de conexión a MySQL con base de datos `vetcare` en `localhost:3306`.
- `USER`: Usuario de la base de datos (`root`).
- `PASSWORD`: Contraseña vacía por defecto.
- `conectar()`: Método estático que intenta establecer la conexión y retorna un objeto `Connection`.

Comportamiento:
- Imprime `Conexión exitosa a MySQL` cuando la conexión se establece.
- Imprime `Error de conexión: ...` si ocurre una excepción.

### 4.2 `interfaces.Vacunable`

Interfaz que define el contrato para animales que pueden ser vacunados.

- `void aplicarVacuna()`: Método que debe implementar cualquier clase de animal vacunable.

### 4.3 `modelo.Animal`

Clase abstracta base para todos los animales del sistema.

Propiedades:
- `id`: Identificador numérico del animal.
- `nombre`: Nombre del animal.
- `edad`: Edad en años.
- `peso`: Peso en kilogramos.
- `raza`: Raza del animal.

Constructores:
- Constructor vacío.
- Constructor completo con todos los atributos.

Métodos:
- `mostrarInformacion()`: Imprime los atributos básicos del animal.
- `calcularCostoConsulta()`: Método abstracto que obliga a las subclases a definir el costo de consulta.
- Getters y setters para cada propiedad.

### 4.4 `modelo.Cita`

Modelo que representa una cita veterinaria.

Propiedades:
- `idCita`: Identificador de la cita.
- `fecha`: Fecha de la cita como texto.
- `motivo`: Motivo de la consulta.
- `costo`: Costo asociado a la cita.

Constructores:
- Constructor vacío.
- Constructor con parámetros completos.

Métodos:
- `registrarCita()`: Imprime un mensaje de confirmación de registro.
- `mostrarCita()`: Imprime los datos de la cita.
- Getters y setters.

### 4.5 `modelo.Dueño`

Representa al propietario de una mascota.

Propiedades:
- `idDueño`: Identificador del dueño.
- `nombre`: Nombre del dueño.
- `telefono`: Teléfono de contacto.
- `direccion`: Dirección del propietario.

Constructores:
- Constructor vacío.
- Constructor completo.

Métodos:
- `mostrarDatos()`: Muestra la información del dueño.
- Getters y setters.

### 4.6 `modelo.Gato`

Clase que extiende `Animal` y representa un gato.
Implementa la interfaz `Vacunable`.

Propiedad adicional:
- `esInterior`: Indica si el gato vive en interior.

Constructores:
- Constructor vacío.
- Constructor completo que recibe `esInterior` además de los atributos básicos.

Métodos:
- `maullar()`: Simula el maullido del gato.
- `mostrarInformacion()`: Muestra información general y específica (`esInterior`).
- `calcularCostoConsulta()`: Retorna `45000` como costo fijo de consulta.
- `aplicarVacuna()`: Mensaje que indica que se ha aplicado la vacuna al gato.
- Getter/setter para `esInterior`.

### 4.7 `modelo.Perro`

Clase que extiende `Animal` y representa un perro.
Implementa la interfaz `Vacunable`.

Propiedad adicional:
- `nivelEnergia`: Describe el nivel de energía del perro.

Constructores:
- Constructor vacío.
- Constructor completo que recibe `nivelEnergia`.

Métodos:
- `ladrar()`: Simula que el perro ladra.
- `mostrarInformacion()`: Muestra información general y específica (`nivelEnergia`).
- `calcularCostoConsulta()`: Retorna `50000` como costo fijo de consulta.
- `aplicarVacuna()`: Mensaje que indica que se ha aplicado la vacuna al perro.
- Getter/setter para `nivelEnergia`.

### 4.8 `modelo.Veterinario`

Representa a un profesional veterinario.

Propiedades:
- `idVeterinario`: Identificador del veterinario.
- `nombre`: Nombre completo.
- `especialidad`: Área de especialización.

Constructores:
- Constructor vacío.
- Constructor completo.

Métodos:
- `atenderMascota()`: Mensaje que indica que está atendiendo una mascota.
- `mostrarDatos()`: Imprime información del veterinario.
- Getters y setters.

## 5. Servicios de APIs externas

### 5.1 `servicios.DogApiService`

Servicio que consume la API pública `https://dog.ceo/api/breeds/list/all`.

Métodos:
- `obtenerRazas()`: Solicita todas las razas de perros y muestra el JSON completo.
- `buscarRaza(String raza)`: Busca si la raza especificada existe en el JSON recibido y muestra un mensaje de resultado.

Detalles de implementación:
- Utiliza `HttpClient.newHttpClient()` para crear el cliente HTTP.
- Construye una petición `HttpRequest` con URI hacia el endpoint.
- Envía la solicitud sincrónicamente con `BodyHandlers.ofString()`.
- Atrapa `IOException` e `InterruptedException` y muestra mensajes de error.

### 5.2 `servicios.CatApiService`

Servicio que consume la API pública `https://api.thecatapi.com/v1/breeds`.

Métodos:
- `obtenerRazas()`: Solicita todas las razas de gatos y muestra el JSON completo.
- `buscarRaza(String raza)`: Busca si la raza especificada está presente en el JSON y muestra un mensaje.

Detalles de implementación:
- Uso idéntico a `DogApiService` con un endpoint diferente.
- Manejo simple de errores con salidas por consola.

## 6. Flujo conceptual del sistema

1. Se modelan animales con `Animal`, y se diferencian en `Perro` y `Gato`.
2. Los animales vacunables implementan `Vacunable` y pueden ejecutar `aplicarVacuna()`.
3. Los datos de propietarios, citas y veterinarios se representan con clases específicas.
4. `Conexion` permite abrir una conexión a la base de datos MySQL de la clínica.
5. Los servicios externos consultan APIs públicas para obtener razas reales de perros y gatos.

## 7. Requisitos de ejecución

- Java 11 o superior.
- MySQL ejecutándose en `localhost` puerto `3306`.
- Base de datos `vetcare` presente en el servidor.
- Usuario `root` sin contraseña, o ajustar `dao/Conexion.java` con credenciales válidas.
- Conexión a Internet para consumir los servicios de razas.

## 8. Configuración de base de datos

La clase `Conexion` está configurada con:

- URL: `jdbc:mysql://localhost:3306/vetcare`
- Usuario: `root`
- Contraseña: `` (vacía)

Recomendaciones:
- Crear la base de datos `vetcare` antes de ejecutar cualquier integración.
- Ajustar usuario y contraseña según el entorno de despliegue.
- Implementar más adelante manejo de recursos con `try-with-resources` para cerrar conexiones.

## 9. Notas de diseño y recomendaciones

- Actualmente no existe una clase `Main` en el proyecto. Sería útil agregar una clase principal que coordine la ejecución de la aplicación.
- Los servicios HTTP retornan la respuesta completa en texto; en una versión futura conviene parsear JSON con una librería como `Gson` o `Jackson`.
- Los precios de consulta en `Perro` y `Gato` están codificados; se recomienda externalizarlos a configuración o persistencia.
- El manejo de errores es básico y usa `System.out.println`; una mejora sería usar `Logger` y excepciones específicas.
- Las clases modelo podrían enriquecerse con validación de datos y métodos adicionales para persistencia.

## 10. Posibles extensiones futuras

- Implementar CRUD completo para mascotas, dueños, citas y veterinarios.
- Añadir capa de servicios para separar lógica de negocio de los modelos.
- Incorporar el patrón DAO para CRUD de todas las entidades.
- Cambiar a un framework web ligero (Spring Boot, Spark Java) para exponer una REST API propia.
- Añadir pruebas unitarias con JUnit para cada clase y servicio.

## 11. Resumen de responsabilidades por archivo

- `dao/Conexion.java`: Gestión de conexión a MySQL.
- `interfaces/Vacunable.java`: Contrato para objetos que pueden ser vacunados.
- `modelo/Animal.java`: Base abstracta de mascotas.
- `modelo/Cita.java`: Entidad de cita veterinaria.
- `modelo/Dueño.java`: Representa el propietario de la mascota.
- `modelo/Gato.java`: Implementación de animal para gatos.
- `modelo/Perro.java`: Implementación de animal para perros.
- `modelo/Veterinario.java`: Representa al profesional veterinario.
- `servicios/CatApiService.java`: Consumo de API de razas de gatos.
- `servicios/DogApiService.java`: Consumo de API de razas de perros.

---

### Observaciones finales

El proyecto tiene una base clara y modular. La documentación presentada aquí describe la arquitectura actual, las responsabilidades de cada componente y las recomendaciones para evolución futura.
