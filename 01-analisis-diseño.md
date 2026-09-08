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