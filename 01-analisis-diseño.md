| ID | Estudiante | Fecha de Inicio |
| :---: | :--- | :---: |
| A | Miranda Cervantes Alfonso | 03/09/2026 |
| B | Rangel Rojas Fabian | 03/09/2026 |

1. Descripción del problema

El sistema a desarrollar busca simular el comportamiento operativo de los tanques de almacenamiento de fluidos dentro de una planta industrial, el sistema debe registrar y administrar los datos esenciales de cada tanque: un identificador único, su capacidad máxima de almacenamiento (en litros), la cantidad de líquido que contiene en tiempo real (nivel actual) y el modo en que se encuentra operando actualmente (detenido, llenando o vaciando).

El sistema debe realizae acciones básicas que permitan:
* Consultar la informacion general del tanque.
* Modificar su estado operativo .
* Alterar físicamente el volumen de fluido contenido.
* Leer el nivel del tanque con sensores.

Para la simulación, se imponen restricciones físicas estrictas: el nivel de fluido de un tanque jamás podrá ser un valor negativo  ni sobrepasar su capacidad máxima declarada .

2. Identificación de objetos

A partir del problema planteado, identificamos los siguientes elementos que deben representarse como objetos:

* **Objeto Tanque:**
  Un recipiente físico de almacenamiento industrial dentro de la planta.
  Es la entidad principal sobre la cual recae la lógica del negocio. Contiene el volumen del fluido y mantiene las reglas físicas que aseguran que el volumen no sobrepase límites no permitidos.
    * **Responsabilidad:** Gestionar su volumen (sumar/restar litros), mantener la consistencia de sus límites físicos (mínimo y máximo) y registrar el estado operativo en el que se encuentra.

* **Objeto SensorDeNivel:**
    *  Un dispositivo electrónico/instrumento de medición montado en el tanque.
    *  Separa la responsabilidad de la *medición* del almacenamiento físico. En un entorno industrial, el operador no mide directamente el estanque, sino que interactúa a través de la lectura devuelta por un instrumento.
    *  Consultar e inspeccionar el estado actual del tanque al que está asignado y transformar esos datos en lecturas comprensibles para la supervisión (como el nivel en litros o el porcentaje).

3. Estado y comportamiento

| Objeto propuesto | Responsabilidad | Información que debe conservar (Estado) | Comportamientos que debe realizar (Comportamiento) |
| :--- | :--- | :--- | :--- |
| **Tanque** | Representar la estructura física del recipiente, almacenar el líquido y validar los límites operacionales. | * Identificador<br>* Capacidad máxima (litros)<br>* Nivel actual (litros)<br>* Estado operativo (`DETENIDO`, `LLENANDO`, `VACIANDO`) | * Permitir modificar su nivel aumentando o disminuyendo litros (respetando topes).<br>* Cambiar el estado de operación.<br>* Permitir consultar la información general del tanque.<br>* Calcular el porcentaje de llenado en base a su nivel y capacidad. |
| **SensorDeNivel** | Proporcionar una lectura indirecta e inspección del estado de un tanque. | * Tanque al que se encuentra asociado/vinculado | * Consultar y retornar el nivel en litros del tanque vinculado.<br>* Consultar y retornar el porcentaje de llenado del tanque.<br>* Generar un reporte o lectura con el formato especificado del estado del tanque. |

4. Relaciones entre los objetos

* **Colaboración entre clases:** El sensor de nivel necesita colaborar con la clase tanque.
* **Información requerida:** El sensor adquiere el nivel del volumen  para entregar una lectura válida.
* **Justificación de la relación:** El tanque es responsable de conservar los datos físicos, el sensor de nivel únicamente funciona como un interprete para el monitoreo sobre el nivel del tanque tanque.
* **No duplicación de responsabilidades:** El sensor se monta directamente al tanque y manda la medidade nivel en tiempo real para evitar datos erroneos.