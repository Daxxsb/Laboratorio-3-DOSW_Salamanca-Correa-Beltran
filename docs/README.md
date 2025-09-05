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

### Parte 1

---

#### Primer Integrante

---

1. Configuración MAVEN
    
    A continuación las capturas donde se evidencia la implementación de las dependencias
    y la prueba de debug y ejecución.
    
    ![1.png](imagenes%2F1.png)
    ![2.png](imagenes%2F2.png)
    ![3.png](imagenes%2F3.png)
    ![4.png](imagenes%2F4.png)
    ![5.png](imagenes%2F5.png)
    ![6.png](imagenes%2F6.png)
    ![7.png](imagenes%2F7.png)

--- 

#### Segundo integrante

---

1. Estructura de carpetas


    ![estructura1.png](imagenes/estructura1.png)
    !
[estructura2.png](imagenes/estructura2.png)

2. Dependencias y pluggins

    ![jacoco.png](imagenes/jacoco.png)


--- 

#### Tercer integrante

--- 

## Historial de Commits

![HistorialCommits.png](imagenes/HistorialCommits.png)
## Preguntas Iniciales

#### A. ¿Cual es la diferencia principal entre una prueba unitaria y una prueba de integracion E2E?

- Prueba Unitaria: Se enfoca en una sola pieza del código (una función, un método, una clase). Se hace de forma aislada, sin depender de otros módulos.

- Prueba de integracion E2E (End to End): Valida que todo el sistema (o varias partes conectadas) funciona de extremo a extremo, tal como lo usaría un usuario real.

#### B. En Scrum ¿Cual es el proposito de la Sprint Retrospective y porque es crucial para la mejora continua del equipo?

El proposito de la Sprint Retrospective es que el equipo reflexione al final de cada sprint sobre lo que salió bien, lo que se puede mejorar y qué acciones concretas tomarán para el siguiente sprint.

Es crucial porque sin esta reunión el equipo repite errores, acumula frustraciones y deja pasar oportunidades de mejorar su forma de trabajar.

#### C. Explique la diferencia entre una Epica, una Feature y una historia de Usuario. Proporcione un ejemplo de cada una si tenemos un sistema de streaming de video como lo es Netflix.

- Epica: Es un objetivo grande, que toma varios sprints y se divide en varias features e historias.
    - Ejemplo: "Mejorar la experiencia de usuario en la plataforma de streaming".

- Feature: Es una capacidad concreta dentro de la épica.
    - Ejemplo: “Recomendaciones personalizadas según el historial de reproducción”.

- Historia de Usuario: Una necesidad especifica vista desde el usuario.
    - Ejemplo: "Como usuario, quiero ver una lista de películas recomendadas basadas en mis gustos para descubrir nuevo contenido fácilmente".

#### D. ¿Que es una cobertura de Codigo (code coverage) y porque una cobertura del 100% no garantiza necesariamente que el software este libre de errores?

La cobertura de código mide qué porcentaje del código fuente es ejecutado durante las pruebas. 

Una cobertura del 100% significa que todas las líneas de código han sido probadas, pero no garantiza que el software esté libre de errores porque puede que el código se ejecute, pero no se estén validando todos los casos o escenarios críticos.

#### E.	Describa que es un Diagrama de Casos de Uso y que elementos lo componen. ¿Para qué sirve en la fase de análisis de requerimientos?

Es un diagrama UML que muestra cómo los actores (usuarios u otros sistemas) interactúan con el sistema a través de casos de uso (funcionalidades).

- Elementos:
  - Actores (Ej: Usuario, Administrador)
  - Casos de Uso (Ej: Iniciar Sesión, Ver Películas)
  - Relaciones (Asociación, Inclusión, Extensión)

En la fase de análisis de requerimientos ayuda a visualizar de manera simple lo que el sistema debe hacer y quién lo va a usar.

#### F.	¿Cuál es la diferencia entre el uso de Junit y Jacoco en un proyecto, y como complementa SonarQube este proceso en términos de calidad de software?

- JUnit: Es un framework para escribir y ejecutar pruebas unitarias en Java.
- JaCoCo: Es una herramienta para medir la cobertura de código, es decir, qué partes del código han sido ejecutadas durante las pruebas.
- SonarQube: Es una plataforma que analiza la calidad del código, incluyendo métricas como la cobertura de código, complejidad, duplicación y vulnerabilidades.

Se complementan de forma que: 

JUnit hace las pruebas -> Jacoco mide la cobertura -> SonarQube evalua la calidad global del proyecto.

#### G.	¿Qué ventajas tiene el uso de Planning Poker frente a otros métodos de estimación tradicional y como ayuda a mejorar la transparencia y compromiso del equipo?

- Ventajas:
  - Fomenta la participación de todo el equipo.
  - Reduce sesgos individuales al hacer estimaciones en grupo.
  - Facilita la discusión y el consenso sobre las tareas.

Mejora la transparencia porque todos entienden cómo se llegó a una estimación y mejora el compromiso porque el equipo se siente parte del proceso.


#### H.	Menciona los valores de Scrum y explica cual consideras más difícil de aplicar en un equipo.

- Valores de Scrum:
  - Compromiso
  - Coraje
  - Enfoque
  - Apertura
  - Respeto

Consideramos que el más difícil de aplicar suele ser Apertura, porque requiere sinceridad total: hablar de errores, limitaciones, bloqueos sin miedo a juicios. Muchos equipos prefieren callar antes que incomodar, y ahí se pierde la esencia.