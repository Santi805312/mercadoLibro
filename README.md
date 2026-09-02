# mercadoLibro

Proyecto de **Ingeniería de Software II**: plataforma para intercambio, compra y gestión de libros entre usuarios.

## Estado actual

El backend se encuentra en `ingenieriaSoftware2/` y está desarrollado con **Java + Spring Boot + Maven**. Actualmente la configuración local utiliza **H2 en memoria** para desarrollo/pruebas.

La base de datos objetivo del proyecto está desplegada en **Supabase/PostgreSQL** y cuenta actualmente con **17 tablas** que modelan usuarios, libros, publicaciones, compras, intercambios, cadenas de intercambio, puntos, reseñas, reportes, listas y notificaciones.

> **Importante:** la documentación de Supabase refleja el estado real de la base de datos al 02/09/2026. El proyecto todavía no debe considerarse listo para producción: las tablas públicas tienen RLS desactivado y debe definirse la política de acceso antes de exponerlas mediante el cliente de Supabase.

## Arquitectura de datos

```text
Usuario
 ├── Publicaciones
 ├── Compras
 ├── Movimientos de puntos
 ├── Reseñas
 ├── Reportes
 ├── Listas
 └── Notificaciones

Libro (metadata/cache)
 ├── Categorías
 ├── Publicaciones
 └── Listas

Publicación
 ├── Historial de precios
 ├── Compras
 ├── Intercambios
 └── Notificaciones

Intercambio
 ├── Movimientos de puntos
 ├── Cadenas
 └── Reseñas

Reporte
 ├── Baneo
 ├── Baja de calificación
 └── Cartel de mal intercambiador
```

## Base de datos

La estructura actual se documenta en [`docs/BASE_DE_DATOS.md`](docs/BASE_DE_DATOS.md).

### Tablas principales

- `usuario`
- `libro_metadata_cache`
- `categoria`
- `CLASIFICADO_EN`
- `publicacion`
- `publicacion_historial_precio`
- `intercambio`
- `compra`
- `movimiento_puntos`
- `cadena`
- `resena`
- `reporte`
- `baneo`
- `bajar_calificacion`
- `cartel_mal_intercambiador`
- `lista`
- `notificacion`

## Seguridad — pendiente crítico

Actualmente **las 17 tablas tienen Row Level Security (RLS) desactivado**. Esto debe resolverse antes de utilizar el Data API de Supabase desde un cliente público.

No se habilita RLS automáticamente porque hacerlo sin políticas bloquearía el acceso a las tablas. Primero hay que definir quién puede leer, insertar, modificar y eliminar cada recurso.

Políticas mínimas a diseñar:

- Un usuario solo puede modificar sus propios datos.
- Un usuario solo puede administrar sus propias publicaciones.
- Las publicaciones disponibles pueden ser visibles públicamente según las reglas del negocio.
- Las listas pertenecen a su usuario.
- Las notificaciones solo son visibles para su destinatario.
- Los movimientos de puntos no deben poder manipularse directamente desde un cliente.
- Compras e intercambios deben protegerse contra modificaciones no autorizadas.
- Reportes, baneos y acciones administrativas deben estar restringidos a los roles correspondientes.

## Backend

```text
ingenieriaSoftware2/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── src/
    ├── main/
    │   ├── java/
    │   └── resources/
    │       └── application.properties
    └── test/
```

La configuración actual de desarrollo utiliza H2 con `create-drop`, por lo que la aplicación local no está conectada todavía a la instancia de Supabase.

## Próximos pasos

1. Modelar las entidades JPA a partir del esquema real de PostgreSQL.
2. Configurar perfiles `dev`/`prod` para separar H2 de Supabase/PostgreSQL.
3. Crear DTOs Request/Response, mappers, servicios y controladores.
4. Implementar autenticación y autorización.
5. Diseñar y activar las políticas RLS apropiadas si el acceso se realiza mediante Supabase Data API.
6. Implementar la lógica de intercambios directos, por puntos y cadenas.
7. Implementar el sistema de saldo, reservas y movimientos de puntos de forma transaccional.
8. Agregar tests de integración contra PostgreSQL.
9. Incorporar migraciones versionadas para que el esquema pueda reproducirse fuera de la instancia actual de Supabase.
10. Ejecutar análisis de calidad y seguridad mediante SonarQube antes de producción.

## Tecnologías

- Java
- Spring Boot
- Spring Data JPA / Hibernate
- Maven
- PostgreSQL / Supabase
- H2 para desarrollo local
- GitHub Actions
- SonarQube
