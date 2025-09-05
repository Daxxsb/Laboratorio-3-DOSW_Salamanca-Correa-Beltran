# Laboratorio-3-DOSW-02

**Integrantes**
- David Eduardo Salamanca Aguilar
- Elizabeth Correa Suarez
- Juan Sebastían Ortega Muñoz

**Nombre del repositorio**
'Laboratorio-3-DOSW_Salamanca-Correa-Ortega'

**Nombre de la rama:**
'feature/lab3_Salamanca_Correa_Ortega_2025-2'

---

## Retos Completados


# Reto 1 - Identificando los Requerimientos

A partir de la lectura del caso fintech su misión es:
    
•	Identifiquen reglas de negocio.

•	Definan las funcionalidades principales.

•	Escriban los actores principales.

•	Documenten las precondiciones necesarias para el sistema.

### Reglas de negocio

o	Los números de cuenta deben tener exactamente 10 dígitos

o	Los dos primeros dígitos corresponden a un banco registrado

o	Las cuentas no deben contener letras ni caracteres especiales

o	Cada cuenta debe estar asociada a un cliente único

### funcionalidades principales

o	Crear una cuenta bancaria válida

o	Validar número de cuenta según las reglas

o	Consultar el saldo de una cuenta

o	Realizar depósitos en una cuenta existente


###  Actores principales

•   Cliente : Crea cuenta, consulta saldo, deposita dinero

•	Sistema Bankify: Valida las reglas de negocio y guarda cuentas

•	Banco externo : El banco establece las reglas sobre con qué números puede empezar una cuenta

### Precondiciones necesarias para el sistema

•	Tener definido el listado de bancos válidos.

•	El sistema debe verificar que la cuenta no exista.

•	Reglas de negocio




# RETO #3: Una estimacion automatizada

## 1) Requerimientos
El sistema debe permitir realizar votaciones para estimar historias de usuario usando la técnica de Planning Poker.
Solo se aceptan los siguientes números al votar: 1, 2, 3, 5, 8, 13.
Si se ingresa un número diferente, se muestra un mensaje de error y se solicita el voto nuevamente.




## 2) ¿Cómo funciona el código?
El programa muestra las historias de usuario a estimar.
Cada integrante vota usando la secuencia permitida.
Si todos los votos son iguales, se alcanza un acuerdo y se asigna el puntaje final a la historia.
Si los votos son diferentes, se solicita discutir y volver a votar hasta lograr consenso.

## 3) Patrones y Principios Utilizados

- Principio de Responsabilidad Única (SRP): Cada clase tiene una única responsabilidad (HistoriaUsuario, Integrante, Votacion, PlanningPoker).
- Encapsulamiento: La lógica de votación y validación está encapsulada en la clase Votacion.
- Separación de Concerns: El flujo principal está en PlanningPoker, la representación de historias en HistoriaUsuario, y los integrantes en Integrante.
- Facilidad de extensión y mantenimiento: La estructura permite agregar nuevas funcionalidades sin afectar el resto del sistema.


## 4) Evidencias

![Reto3DinamismoEntrada.png](docs/imagenes/Reto3DinamismoEntrada.png)
![Reto3CorrectoFuncionamiento.png](docs/imagenes/Reto3CorrectoFuncionamiento.png)
![Reto3CasoUnIntegrante.png](docs/imagenes/Reto3CasoUnIntegrante.png)



---

## Historial de Commits

![HistorialCommits.png](docs/imagenes/HistorialCommits.png)


# 💻 RETO #4: Tiempo De Desarrollo

## Enunciado
En este reto se implementó la clase **`ValidadorCuenta`**, **`CuentaBancaria`**, **`AdministradorCuenta`** y **`Movimiento`** aplicando la metodología **TDD (Test Driven Development)**.  

El proceso seguido fue:

1. Crear pruebas unitarias con **JUnit 5**.  
2. Implementar la clase de validación en una primera versión (Etapa 1).  
3. Ejecutar las pruebas y confirmar que pasaran.  
4. Realizar un **refactor** para mejorar el código (Etapa 2).  
5. Verificar nuevamente que las pruebas siguieran pasando.  

---



> ## 🔹 CLASE VALIDADOR CUENTA

## 🧪💻 Pruebas diseñadas

Se definieron distintos casos para cubrir las reglas de negocio de las cuentas:

- **Formato válido:** cuentas con 10 dígitos (`0123456789`, `0200000000`).  
- **Formato inválido:** vacías, con espacios, menos/más de 10 dígitos, letras o símbolos (`12345`, `01A2345678`, `00123456789`).  
- **Nulos:** entradas `null` o `""` siempre inválidas.  
- **Banco válido:** prefijos registrados `01`, `02` (`0112345678`, `0211111111`).  
- **Banco inválido:** prefijos no registrados (`00`, `09`, `99`).  
- **Validación integral:** combina ambas reglas → ejemplos válidos (`0112345678`) e inválidos (`9912345678`, `012345678`).

## 🔴 Ejecución inicial de pruebas
Antes de implementar la lógica, las pruebas fallaban ya que no se tenia la implementacion de los metodos

**Evidencia:**  
![Reto4TestFallidos](docs/imagenes/Reto4TestFallidos.png)

---

## 📌 Implementación (Etapa 1)
Se implementó una primera versión de la clase **`ValidadorCuenta`**, con bucles tradicionales y validaciones básicas.

## ✅ Ejecución de pruebas Despues de la implementación
Con la implementación de la Etapa 1, las pruebas pasan exitosamente.

**Evidencia:**  
![Reto4TestSuperados1](docs/imagenes/Reto4TestSuperados1.png)
![Reto4TestSuperados2](docs/imagenes/Reto4TestSuperados2.png)

## ⚙️📌 Refactor (Etapa 2)
Se mejoró el código aplicando Streams y Lambdas:

- Uso de chars().allMatch(...) para verificar que todos los caracteres sean dígitos.

- Uso de Set<String> con los prefijos de bancos registrados para hacer la validación más eficiente.

## 🔧✅ Ejecución de pruebas despues del refactor
Después del refactor, todas las pruebas se ejecutan correctamente sin romper la funcionalidad.

**Evidencia:**  
![Reto4TestRefactor1](docs/imagenes/Reto4TestRefactor1.png)
![Reto4TestRefactor2](docs/imagenes/Reto4TestRefactor2.png)



> ## 🔹 CLASE CUENTA BANCARIA

## 🧪💻 Pruebas diseñadas

Se definieron distintos casos para cubrir las reglas de negocio de las cuentas:

- **Saldo inicial:** al crear una cuenta, el saldo debe ser `0.0`.  
- **Depósito válido:** al depositar un monto positivo, el saldo aumenta y se registra un movimiento con monto, fecha y número de cuenta.  
- **Depósito inválido:** al intentar depositar `0` o un valor negativo, se lanza una excepción (`IllegalArgumentException`).  

## 🔴 Ejecución inicial de pruebas
Antes de implementar la lógica, las pruebas fallaban ya que no se tenia la implementacion de los metodos

**Evidencia:**  
![Reto4TestFallidosCuentaB](docs/imagenes/Reto4TestFallidosCuentaB.png)

---

## 📌 Implementación (Etapa 1)
Se implementó una primera versión de la clase **`CuentaBancaria`**, con un atributo de saldo y un historial básico de movimientos.

## ✅ Ejecución de pruebas después de la implementación
Con la implementación de la Etapa 1, las pruebas pasan exitosamente.

**Evidencia:**  
![Reto4TestSuperadosCuentaB](docs/imagenes/Reto4TestSuperadosCuentaB.png)


## ⚙️📌 Refactor (Etapa 2)
Se mejoró el código aplicando prácticas de inmutabilidad y listas no modificables para el historial, además de simplificar la lógica del depósito.

## 🔧✅ Ejecución de pruebas después del refactor
Después del refactor, todas las pruebas se ejecutan correctamente sin romper la funcionalidad.

**Evidencia:**  

![Reto4CuentaBancariaRefactor](docs/imagenes/Reto4CuentaBancariaRefactor.png)



> ## 🔹 CLASE ADMINISTRADOR CUENTA

## 🧪💻 Pruebas diseñadas

Se definieron distintos casos para cubrir las reglas de negocio de las cuentas:

- **Crear cuenta válida:** se puede crear una cuenta con número correcto, asociarla a un cliente y consultar saldo inicial `0.0`.  
- **Crear cuenta inválida:** si el número no cumple las reglas, se lanza una excepción.  
- **Depositar desde administrador:** el administrador permite hacer un depósito, lo que incrementa el saldo y guarda un movimiento en el historial.  

## 🔴 Ejecución inicial de pruebas
Antes de implementar la lógica, las pruebas fallaban ya que no se tenia la implementacion de los metodos

**Evidencia:**  
![Reto4TestFallidosAdmin](docs/imagenes/Reto4TestFallidosAdmin.png)

---

## 📌 Implementación (Etapa 1)
Se implementó una primera versión de la clase **`AdministradorCuenta`**, con un mapa interno para almacenar cuentas y un validador para los números de cuenta.

## ✅ Ejecución de pruebas después de la implementación
Con la implementación de la Etapa 1, las pruebas pasan exitosamente.

**Evidencia:**  
![Reto4TestSuperadosAdmin](docs/imagenes/Reto4TestSuperadosAdmin.png)

## ⚙️📌 Refactor (Etapa 2)
Se optimizó el manejo de cuentas usando `Objects.requireNonNull`, validaciones más claras y mejor organización interna del código.

## 🔧✅ Ejecución de pruebas después del refactor
Después del refactor, todas las pruebas se ejecutan correctamente sin romper la funcionalidad.

**Evidencia:**  

![Reto4AdministradorCuentaRefactor](docs/imagenes/Reto4AdministradorCuentaRefactor.png)




> ## 🔹 CLASE MOVIMIENTO

## 🧪💻 Pruebas diseñadas

Se definieron distintos casos para cubrir las reglas de negocio de las cuentas:

- **Notificación de movimiento:** cuando un `Movimiento` cambia su monto y tiene al `AdministradorCuenta` como observador, se notifica y el saldo de la cuenta correspondiente se actualiza correctamente.   

## 🔴 Ejecución inicial de pruebas
Antes de implementar la lógica, las pruebas fallaban ya que no se tenia la implementacion de los metodos

**Evidencia:**  
![Reto4TestFallidosMov](docs/imagenes/Reto4TestFallidosMov.png)

---

## 📌 Implementación (Etapa 1)
Se implementó la clase **`Movimiento`** como sujeto con lista de observadores, y la clase **`AdministradorCuenta`** como observador que reacciona al recibir notificaciones.

## ✅ Ejecución de pruebas después de la implementación
Con la implementación de la Etapa 1, las pruebas pasan exitosamente.

**Evidencia:**  
![Reto4TestSuperadosMov](docs/imagenes/Reto4TestSuperadosMov.png)

## ⚙️📌 Refactor (Etapa 2)
Se mejoró el código aplicando uso de `Streams` para notificar observadores, validación con `Objects.requireNonNull` y mayor encapsulamiento de atributos.

## 🔧✅ Ejecución de pruebas después del refactor
Después del refactor, todas las pruebas se ejecutan correctamente sin romper la funcionalidad.

**Evidencia:**  

![Reto4MovimientoObserver](docs/imagenes/Reto4MovimientoObserver.png)

### 🧩PATRON DE DISEÑO UTILIZADO

Se utilizó el patrón de diseño **Observer** para gestionar la relación entre `Movimiento` y `AdministradorCuenta` porque permite que cada vez que ocurre un cambio en un movimiento (por ejemplo, un depósito) se notifique automáticamente al administrador, garantizando que el saldo de la cuenta se mantenga siempre actualizado sin necesidad de acoplar directamente ambas clases; de esta manera se logra un sistema más flexible, fácil de mantener y preparado para futuras extensiones, como agregar otros observadores que reaccionen a los movimientos (auditorías, notificaciones, reportes) sin modificar la lógica principal.




