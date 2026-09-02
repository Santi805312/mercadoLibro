# Base de datos — mercadoLibro

Documento generado a partir de la estructura real del proyecto Supabase `yqwkiugnpgeigntkwipi`.

**Última revisión:** 02/09/2026  
**Motor:** PostgreSQL 17.6  
**Región:** us-east-1  
**Estado del proyecto:** ACTIVE_HEALTHY

## Resumen

La base de datos contiene 17 tablas en el esquema `public`. Actualmente todas aparecen con 0 filas.

### Tablas

1. `usuario`
2. `libro_metadata_cache`
3. `categoria`
4. `CLASIFICADO_EN`
5. `publicacion`
6. `publicacion_historial_precio`
7. `intercambio`
8. `compra`
9. `movimiento_puntos`
10. `cadena`
11. `resena`
12. `reporte`
13. `baneo`
14. `bajar_calificacion`
15. `cartel_mal_intercambiador`
16. `lista`
17. `notificacion`

## Modelo funcional

### Usuario

`usuario` utiliza `email` como clave primaria y contiene:

- email
- nombre de usuario
- rol (`ADMINISTRADOR`, `USUARIO`)
- saldo total y saldo reservado
- reputación promedio
- estado de cuenta (`ACTIVA`, `SUSPENDIDA`, `BANEADA`)
- preferencias de notificación
- hora del resumen diario

Se relaciona con publicaciones, compras, movimientos de puntos, reseñas, reportes, listas y notificaciones.

### Libros y categorías

`libro_metadata_cache` utiliza `isbn` como clave primaria y almacena metadata bibliográfica, Google Books ID, autores y puntuación externa.

`categoria` utiliza el nombre como clave primaria y permite categorías jerárquicas mediante `categoria_padre_id`.

`CLASIFICADO_EN` implementa la relación muchos-a-muchos entre libros y categorías.

### Publicaciones

`publicacion` utiliza una clave primaria compuesta por:

- ISBN
- propietario
- hora de publicación

Contiene estado físico, puntos solicitados, valor de referencia, comentario, estado de la publicación y color del semáforo.

Estados de publicación:

- `DISPONIBLE`
- `RESERVADA`
- `VENDIDA`
- `ELIMINADA`

`publicacion_historial_precio` registra cambios de precio y de color del semáforo.

### Compras

`compra` relaciona comprador con una publicación y registra los puntos utilizados.

### Intercambios

`intercambio` modela intercambios entre una publicación solicitada y una publicación ofrecida.

Tipos:

- `DIRECTO`
- `CON_PUNTOS`

Estados:

- `PENDIENTE`
- `ACEPTADO`
- `RECHAZADO`
- `CANCELADO`
- `COMPLETADO`

También existe `puntos_comprometidos` para representar puntos reservados durante el proceso.

### Cadenas de intercambio

`cadena` conecta dos intercambios mediante referencias al intercambio anterior y al siguiente.

Estados:

- `ACTIVA`
- `COMPLETADA`
- `CANCELADA`

Este modelo permite representar cadenas donde un intercambio habilita o conecta con otro.

### Puntos

`movimiento_puntos` registra movimientos asociados a usuarios e intercambios.

Tipos:

- `INGRESO`
- `EGRESO`
- `RESERVA`
- `LIBERACION_RESERVA`
- `DEVOLUCION`

El monto debe ser positivo.

### Reputación y moderación

`resena` registra calificaciones de 1 a 5 y puede clasificarse como `POSITIVA` o `NEGATIVA`.

`reporte` permite denunciar usuarios y clasifica el motivo y estado del reporte.

`baneo`, `bajar_calificacion` y `cartel_mal_intercambiador` representan acciones derivadas de reportes.

### Listas

`lista` vincula usuarios con libros y permite almacenar:

- nota privada
- precio mínimo
- precio máximo
- condiciones aceptables
- fecha de agregado

### Notificaciones

`notificacion` utiliza un ID autogenerado y referencia al usuario y, cuando corresponde, a una publicación.

Tipos actuales:

- `PUBLICACION_NUEVA`
- `BAJA_PRECIO`
- `CRUCE_VERDE`
- `OTRO`

También mantiene estados `leida` y `archivada`.

## Integridad referencial

El esquema utiliza claves foráneas para conectar usuarios, libros, publicaciones, intercambios, compras, movimientos de puntos, cadenas, reseñas, reportes, listas y notificaciones.

Las publicaciones son identificadas por una clave compuesta (`isbn`, propietario, hora de publicación), y los intercambios referencian publicaciones completas mediante esa misma clave compuesta.

## Restricciones relevantes

El esquema ya incorpora varias validaciones mediante `CHECK`, entre ellas:

- saldos de usuario no negativos
- reputación entre 1 y 5
- puntuación externa entre 0 y 5
- puntos solicitados no negativos
- valor de referencia no negativo
- puntos comprometidos no negativos
- puntos de compra positivos
- montos de movimientos positivos
- calificaciones de reseñas entre 1 y 5

## Seguridad — CRÍTICO

En la revisión actual, **las 17 tablas tienen RLS desactivado**.

Esto significa que las tablas del esquema `public` pueden quedar expuestas a los roles utilizados por el Data API de Supabase si cuentan con los permisos correspondientes. Para una aplicación con datos de usuarios, puntos, compras, intercambios y moderación esto debe considerarse un bloqueo para producción.

### No activar RLS sin políticas

No se debe solucionar simplemente activando RLS en todas las tablas: si no existen políticas apropiadas, el acceso de la aplicación puede quedar bloqueado.

La estrategia recomendada es:

1. Definir el modelo de autenticación.
2. Definir qué operaciones puede realizar cada rol.
3. Crear políticas RLS específicas por tabla.
4. Probar lectura, creación, modificación y eliminación con usuarios normales y administradores.
5. Recién después habilitar RLS en producción.

### Políticas que deberán contemplarse

- Los usuarios solo deben poder modificar sus propios datos.
- Las listas deben estar aisladas por usuario.
- Las notificaciones solo deben ser visibles para su destinatario.
- Un usuario no debe poder modificar movimientos de puntos arbitrariamente.
- Compras e intercambios deben tener permisos restringidos según sus participantes y estados.
- Las acciones de moderación deben estar restringidas a administradores o al flujo autorizado.
- Las publicaciones públicas deben poder consultarse sin permitir modificaciones arbitrarias.

## Backend y base de datos

Actualmente el backend del repositorio utiliza H2 en memoria con `spring.jpa.hibernate.ddl-auto=create-drop` para desarrollo. Por lo tanto, el esquema de Supabase documentado aquí todavía no es generado ni administrado automáticamente por las entidades JPA del backend.

El siguiente paso recomendado es introducir migraciones versionadas y configurar PostgreSQL/Supabase como entorno de integración, manteniendo H2 únicamente para tests rápidos si sigue siendo compatible con el modelo.

## Próxima evolución recomendada

1. Crear migraciones SQL versionadas que reproduzcan el esquema.
2. Revisar claves primarias compuestas y evaluar IDs técnicos donde simplifiquen JPA/API.
3. Definir índices para las consultas principales.
4. Diseñar RLS.
5. Definir autenticación y autorización.
6. Conectar Spring Boot con PostgreSQL.
7. Crear entidades JPA y repositorios.
8. Implementar servicios transaccionales para compras, intercambios y puntos.
9. Crear tests de integración.
10. Revisar seguridad y rendimiento antes del despliegue.
