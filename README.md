# Foro con Spring Boot
Foro realizado con Java y Spring boot, que permite la creación, actualización y eliminar foros. Permite crear usuarios por medio de JWT, y así mismo autenticarlos. MySQL usado como base de datos

## Tecnologías Utilizadas
+ Java 17
+ Spring Boot 3.3.1
+ Spring Data JPA
+ Spring Security
+ JWT (JSON Web Token)
+ MySQL
+ Lombok

## Funcionalidades
+ Gestión de usuarios:
+ Registro de usuarios
+ Autenticación y autorización con JWT
+ Gestión de publicaciones:
+ Crear nuevas publicaciones
+ Leer publicaciones existentes
+ Actualizar publicaciones
+ Eliminar publicaciones

## Requisitos
+ Java 17 o superior
+ Maven 3.6.0 o superior
+ MySQL 8.0 o superior
+ PostgreSQL 13.0 o superior

## Uso
Endpoints Principales
Autenticación:

+ POST /auth/register - Registro de nuevos usuarios
+ POST /auth/login - Inicio de sesión de usuarios

Publicaciones:

+ GET /topicos - Listar todas las publicaciones
+ POST /topicos - Crear una nueva publicación
+ GET /ordenados - Listar topicos ordenados por fecha
+ GET /buscar - Buscar topico 
+ GET /topicos/id - Buscar topico por ID
+ PUT /topicos/id - Actualizar topico por ID
+ DELETE /posts/id - Eliminar topico por ID

  
## Configuración del Proyecto
Dependencias:


```
<dependencies>
    <!-- Dependencias de Spring Boot -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
    </dependency>
    
    <!-- Dependencia para MySQL -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <!-- Dependencias para JWT -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.11.2</version>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-impl</artifactId>
        <version>0.11.2</version>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-jackson</artifactId>
        <version>0.11.2</version>
        <scope>runtime</scope>
    </dependency>
    
    <!-- Dependencias de Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <scope>provided</scope>
    </dependency>
    
    <!-- Dependencias de pruebas -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### Configuración 'Application.properties'

```
spring.datasource.url=jdbc:mysql://localhost:3306/foro
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Configuración de JWT
security.jwt.key.private=tu_clave_secreta
security.jwt.key.public=tu_clave_publica
```

