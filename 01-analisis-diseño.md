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