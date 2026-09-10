| ID | Estudiante | Fecha de Inicio |
| :---: | :--- | :---: |
| A | Miranda Cervantes Alfonso | 03/09/2026 |
| B | Rangel Rojas Fabian | 03/09/2026 |

1. Descripción del problema

El sistema a desarrollar busca modelar y simular el comportamiento operativo de los tanques de almacenamiento de fluidos dentro de una planta industrial.

Para llevar a cabo una gestión adecuada, el sistema debe registrar y administrar los datos esenciales de cada tanque: un identificador único, su capacidad máxima de almacenamiento expresada en litros, la cantidad de líquido que contiene en tiempo real (nivel actual) y el modo en que se encuentra operando actualmente (detenido, en proceso de llenado o en proceso de vaciado).

El sistema debe ofrecer funcionalidades operativas básicas que permitan:
* Consultar la información general del tanque (identificador, capacidad, nivel, porcentaje de llenado y estado).
* Modificar su estado operativo (iniciar llenado, iniciar vaciado, detener).
* Alterar físicamente el volumen de fluido contenido (añadir o extraer litros).
* Leer el nivel de almacenamiento a través de un componente dedicado que actúe como interfaz de medición (sensor).

Para asegurar la integridad de la simulación, se imponen restricciones físicas estrictas: el nivel de fluido de un tanque jamás podrá ser un valor negativo ($0\text{ L}$) ni sobrepasar su capacidad máxima declarada ($Nivel \le Capacidad$).

2. Identificación de objetos

A partir del problema planteado, identificamos los siguientes elementos que deben representarse como objetos:

* **Objeto Tanque:**
    * **Qué representa:** Un recipiente físico de almacenamiento industrial dentro de la planta.
    * **Por qué debe existir:** Es la entidad principal sobre la cual recae la lógica del negocio. Contiene el volumen del fluido y mantiene las reglas físicas que aseguran que el volumen no sobrepase límites no permitidos.
    * **Responsabilidad:** Gestionar su volumen (sumar/restar litros), mantener la consistencia de sus límites físicos (mínimo y máximo) y registrar el estado operativo en el que se encuentra.

* **Objeto SensorDeNivel:**
    * **Qué representa:** Un dispositivo electrónico/instrumento de medición montado en el tanque.
    * **Por qué debe existir:** Separa la responsabilidad de la *medición* del almacenamiento físico. En un entorno industrial, el operador no mide directamente el estanque, sino que interactúa a través de la lectura devuelta por un instrumento.
    * **Responsabilidad:** Consultar e inspeccionar el estado actual del tanque al que está asignado y transformar esos datos en lecturas comprensibles para la supervisión (como el nivel en litros o el porcentaje).

3. Estado y comportamiento

| Objeto propuesto | Responsabilidad | Información que debe conservar (Estado) | Comportamientos que debe realizar (Comportamiento) |
| :--- | :--- | :--- | :--- |
| **Tanque** | Representar la estructura física del recipiente, almacenar el líquido y validar los límites operacionales. | * Identificador<br>* Capacidad máxima (litros)<br>* Nivel actual (litros)<br>* Estado operativo (`DETENIDO`, `LLENANDO`, `VACIANDO`) | * Permitir modificar su nivel aumentando o disminuyendo litros (respetando topes).<br>* Cambiar el estado de operación.<br>* Permitir consultar la información general del tanque.<br>* Calcular el porcentaje de llenado en base a su nivel y capacidad. |
| **SensorDeNivel** | Proporcionar una lectura indirecta e inspección del estado de un tanque. | * Tanque al que se encuentra asociado/vinculado | * Consultar y retornar el nivel en litros del tanque vinculado.<br>* Consultar y retornar el porcentaje de llenado del tanque.<br>* Generar un reporte o lectura con el formato especificado del estado del tanque. |

4. Relaciones entre los objetos

* **Colaboración entre clases:** El `SensorDeNivel` necesita colaborar con la clase `Tanque`.
* **Información requerida:** El sensor no almacena volumen ni capacidad por sí mismo; para entregar una lectura válida, necesita consultar de manera directa la información almacenada en el objeto `Tanque` que tiene asignado.
* **Justificación de la relación:** Esta separación aplica el principio de responsabilidad única. El `Tanque` es responsable de conservar los datos físicos e impedir estados no válidos (por ejemplo, evitar que se llene de más). El `SensorDeNivel` únicamente actúa como un medio de lectura/monitoreo sobre dicho tanque.
* **No duplicación de responsabilidades:** El sensor no debe guardar una copia independiente de la capacidad ni del nivel actual. Toda consulta de lectura realizada por el sensor debe leerse directamente del tanque en tiempo real para evitar inconsistencias de datos.

| Clase | Atributos propuestos | Tipo de datos | Metodos propuestos |
| :--- | :--- | :--- | :--- |
| Tanque | ID | string | Privado |
| Tanque | Capacidad Max. | double | Privado |
| Tanque | Nivel Actual | double | Privado |
| Tanque | Estado | EstadoTanque | Privado |
| Tanque | Tanque(ID, Capacidad Max.) | constructor | Publico |
| Tanque | Llenar(Cantidad) | void | Publico |
| Tanque | Vaciar(Cantidad) | void | Publico |
| Tanque | Detener() | void | Publico |
| Tanque | ConsultarNivel() | double | Publico |
| Tanque | CalcularOcupacion() | double | Publico |
| Tanque | getNivel() | EstadoTanque | Publico |
| Sensor | ID | string | Privado |
| Sensor | UltimaLectura | double | Privado |
| Sensor | TanqueAsociado | Tanque | Privado |
| Sensor | Sensor(ID, Tanque) | string | Publico |
| Sensor | LeerNivel() | double | Publico |
| Sensor | ValidarLectura(valor) | bool | Publico |
| Sensor | getUltimaLectura() | double | Publico |
