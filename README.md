# shopping-back

Este repositorio contiene el esqueleto de un proyecto **Spring Boot** para un sistema de carrito de compras.

## Requisitos
- Java 17+
- Maven 3.9+
- MySQL disponible en `localhost:3306` con base de datos `shopping` y credenciales `root` / `1qaz2wsX`.

## Compilación
```bash
mvn clean package
```

## Ejecución
```bash
mvn spring-boot:run
```

Una vez iniciado, la documentación Swagger estará disponible en `http://localhost:8080/swagger-ui.html`.
