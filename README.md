# Java Test Project

Este es un proyecto de prueba utilizando Spring Boot, JPA y PostgreSQL para gestionar productos y categorías en una tienda online.

## Descripción

El proyecto consiste en una aplicación que permite gestionar productos y categorías. La aplicación incluye funcionalidades para:

- Ver y administrar categorías y productos.
- Agregar, eliminar y listar productos y categorías.
- Filtrar productos por categoría.
- Buscar productos por ID.

## Requisitos

- **Java 17** o superior.
- **PostgreSQL** como base de datos.
- **Spring Boot** para la configuración y ejecución del proyecto.
- **Maven** o **Gradle** para la gestión de dependencias.

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

- **DTOs**: Contiene los objetos de transferencia de datos para los productos.
- **Mapper**: Contiene clases para convertir entidades entre las clases de entidad y los DTOs.
- **Controller**: Controladores para gestionar las vistas y la interacción con los usuarios.
- **Templates**: Archivos HTML que utilizan Thymeleaf para renderizar las vistas.
- **SQL Scripts**: Archivos SQL para la creación de las tablas y la inserción de datos iniciales.

## Configuración de la Base de Datos

La base de datos está configurada para usar **PostgreSQL**. Asegúrate de tener una base de datos llamada `campusjavatest` en tu servidor de PostgreSQL. Puedes usar las siguientes configuraciones de ejemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:1402/campusjavatest
spring.datasource.username=user
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver
```

# Estructura de la Base de Datos

## Tablas

### `category`
Almacena las categorías de productos.

- **id**: Identificador único de la categoría.
- **name**: Nombre de la categoría (por ejemplo, "Electronics", "Clothing").

### `product`
Almacena los productos disponibles.

- **id**: Identificador único del producto.
- **name**: Nombre del producto.
- **description**: Descripción del producto.
- **price**: Precio del producto.
- **categoryid**: Relación con la tabla `category`.

## SQL para crear las tablas e insertar datos

```sql
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;

CREATE TABLE category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL CHECK (price > 0),
    categoryid INTEGER REFERENCES category(id)
);

INSERT INTO category (name) VALUES
('Electronics'),
('Clothing'),
('Toys'),
('Books'),
('Home Appliances');

INSERT INTO product (name, description, price, categoryid) VALUES
('Smartphone', 'Latest model with amazing features', 599.99, 1),
('T-Shirt', 'Comfortable cotton t-shirt', 19.99, 2),
('Lego Set', 'Building blocks set for kids', 49.99, 3),
('Novel Book', 'A thrilling adventure novel', 12.99, 4),
('Washing Machine', 'High efficiency washing machine', 299.99, 5),
('Headphones', 'Noise-cancelling headphones', 129.99, 1),
('Jeans', 'Blue denim jeans', 39.99, 2),
('Action Figure', 'Superhero action figure', 24.99, 3),
('Cookbook', 'Delicious recipes from around the world', 15.99, 4),
('Microwave', 'Compact microwave oven', 99.99, 5);
```

# Configuración de Spring Boot

## Configuración de la base de datos

Asegúrate de tener las siguientes configuraciones en tu archivo `application.properties`:

```properties
spring.application.name=java_test

# Configuración de la base de datos
spring.datasource.url=jdbc:postgresql://localhost:1402/campusjavatest
spring.datasource.username=user
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver

# Configuración de JPA
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true 

spring.sql.init.mode=always

# Ejecutar los scripts de inicialización
spring.sql.init.schema-locations=classpath:schema.sql
spring.sql.init.data-locations=classpath:data.sql
```

# Dependencias de Maven

Este proyecto usa Maven para gestionar las dependencias. Asegúrate de tener las siguientes dependencias en tu archivo `pom.xml`:

```xml
<dependencies>
    <!-- Spring Boot dependencies -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.2.23</version>
    </dependency>
</dependencies>
```

# Funcionalidades

## Vistas

- `/categoriesPage`: Página para gestionar categorías de productos.
- `/productsPage`: Página para gestionar productos y filtrarlos por categoría.

## Funcionalidades principales

- Crear y eliminar categorías.
- Crear, eliminar y listar productos.
- Filtrar productos por categoría.
- Buscar productos por ID.

## Rutas de la API

- `GET /api/categories`: Obtener todas las categorías.
- `POST /api/categories`: Crear una nueva categoría.
- `DELETE /api/categories/{id}`: Eliminar una categoría.
- `GET /api/products`: Obtener todos los productos.
- `POST /api/products`: Crear un nuevo producto.
- `DELETE /api/products/{id}`: Eliminar un producto.
- `GET /api/products/category/{categoryId}`: Obtener productos filtrados por categoría.
- `GET /api/products/{id}`: Buscar un producto por ID.

# Cómo ejecutar el proyecto

 Cómo ejecutar el proyecto

## Paso 1: Configurar el archivo `application.properties`

1. **Configura el archivo `application.properties`** en el directorio `src/main/resources` **y la clase `DatabaseInitializer`** en el directorio `src/main/java/com/java_test/java_test/databaseConfig` con los siguientes parámetros:

    ```properties
    spring.application.name=java_test

    # Configuración de la base de datos
    spring.datasource.url=jdbc:postgresql://localhost:1402/campusjavatest # Cambiar ruta de ser necesario (Ajustar puerto)
    spring.datasource.username=user # Cambiar usuario
    spring.datasource.password=password # Cambiar contraseña
    spring.datasource.driver-class-name=org.postgresql.Driver

    # Configuración de JPA
    spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true 

    spring.sql.init.mode=always

    # Ejecutar los scripts de inicialización
    spring.sql.init.schema-locations=classpath:schema.sql
    spring.sql.init.data-locations=classpath:data.sql
    ```

   **Ejemplo de configuración**:
   ```java
   package com.java_test.java_test.databaseConfig;

   import java.sql.Connection;
   import java.sql.DriverManager;
   import java.sql.Statement;

   public class DatabaseInitializer {
       
       
       public static void initializeDatabase() {
           // Parámetros de conexión a la base de datos
           String url = "jdbc:postgresql://localhost:1402/postgres"; // URL del servidor PostgreSQL
           String user = "postgres"; // Nombre de usuario configurado en application.properties
           String password = "password"; // Contraseña configurada en application.properties

           try (
               
               Connection conn = DriverManager.getConnection(url, user, password);
               
               Statement stmt = conn.createStatement()
           ) {
               
               String checkDatabase = "SELECT 1 FROM pg_database WHERE datname = 'campusjavatest'"; // Si se cambia el nombre de la base de datos en el application.properties
               }                                                                                    // también se debe cambiar acá
               var rs = stmt.executeQuery(checkDatabase);

               
               if (!rs.next()) {
                  
                   String createDatabase = "CREATE DATABASE campusjavatest"; // Si se cambia el nombre de la base de datos en el application.properties también se debe cambiar acá                                                              
                   stmt.executeUpdate(createDatabase);
                   // Mensaje de éxito
                   System.out.println("Base de datos creada exitosamente!!");
               } else {
                   
                   System.out.println("La base de datos ya existe");
               }
           } catch (Exception e) {
               
               e.printStackTrace();
           }
       }
   }
   ```
    Asegúrate de que la URL de la base de datos, el nombre de usuario y la contraseña coincidan con tu configuración de PostgreSQL.



## Paso 2: Inicializar la base de datos

1. **Crea los scripts SQL para inicializar la base de datos**:
   
    - **`schema.sql`**: Este archivo contiene la definición de las tablas. Asegúrate de tener el siguiente contenido:

        ```sql
        DROP TABLE IF EXISTS product;
        DROP TABLE IF EXISTS category;

        CREATE TABLE category (
            id SERIAL PRIMARY KEY,
            name VARCHAR(50) NOT NULL UNIQUE
        );

        CREATE TABLE product (
            id SERIAL PRIMARY KEY,
            name VARCHAR(50) NOT NULL,
            description VARCHAR(255),
            price DECIMAL(10, 2) NOT NULL CHECK (price > 0),
            categoryid INTEGER REFERENCES category(id)
        );
        ```

    - **`data.sql`**: Este archivo se utiliza para insertar datos de prueba en las tablas. Asegúrate de tener el siguiente contenido:

        ```sql
        INSERT INTO category (name) VALUES
        ('Electronics'),
        ('Clothing'),
        ('Toys'),
        ('Books'),
        ('Home Appliances');

        INSERT INTO product (name, description, price, categoryid) VALUES
        ('Smartphone', 'Latest model with amazing features', 599.99, 1),
        ('T-Shirt', 'Comfortable cotton t-shirt', 19.99, 2),
        ('Lego Set', 'Building blocks set for kids', 49.99, 3),
        ('Novel Book', 'A thrilling adventure novel', 12.99, 4),
        ('Washing Machine', 'High efficiency washing machine', 299.99, 5),
        ('Headphones', 'Noise-cancelling headphones', 129.99, 1),
        ('Jeans', 'Blue denim jeans', 39.99, 2),
        ('Action Figure', 'Superhero action figure', 24.99, 3),
        ('Cookbook', 'Delicious recipes from around the world', 15.99, 4),
        ('Microwave', 'Compact microwave oven', 99.99, 5);
        ```

    Estos scripts se ejecutarán automáticamente al iniciar la aplicación, gracias a la configuración en `application.properties`.

## Paso 3: Ejecutar el proyecto

1. **Clona el repositorio**:

    ```bash
    git clone <URL-del-repositorio>
    ```

2. **Navega a la carpeta del proyecto**:

    ```bash
    cd <nombre-del-proyecto>
    ```

3. **Asegúrate de tener PostgreSQL instalado y configurado** en tu máquina.

4. **Ejecuta la aplicación**:

    ```bash
    ./mvnw spring-boot:run
    ```

    O si prefieres usar Maven directamente:

    ```bash
    mvn spring-boot:run
    ```

5. **Accede a la aplicación en tu navegador** en `http://localhost:8080`.

## Paso 4: Probar la aplicación desde las páginas web

1. **Gestionar categorías**:
    - Visita `http://localhost:8080/categoriesPage` para agregar, eliminar y listar categorías de productos.

2. **Gestionar productos**:
    - Visita `http://localhost:8080/productsPage` para agregar, eliminar y listar productos.
    - Filtra productos por categoría.

## Paso 5: Probar la API con herramientas como Insomnia o Postman

Puedes usar herramientas como **Insomnia** o **Postman** para realizar peticiones a la API y probar la funcionalidad.

### Ejemplo de peticiones:

1. **Obtener todas las categorías**:
    - Método: `GET`
    - URL: `http://localhost:8080/api/categories`

2. **Crear una nueva categoría**:
    - Método: `POST`
    - URL: `http://localhost:8080/api/categories`
    - Body (JSON):

    ```json
    {
      "name": "Sports"
    }
    ```

3. **Eliminar una categoría**:
    - Método: `DELETE`
    - URL: `http://localhost:8080/api/categories/1`

4. **Obtener todos los productos**:
    - Método: `GET`
    - URL: `http://localhost:8080/api/products`

5. **Crear un nuevo producto**:
    - Método: `POST`
    - URL: `http://localhost:8080/api/products`
    - Body (JSON):

    ```json
    {
      "name": "Football",
      "description": "A soccer ball",
      "price": 19.99,
      "categoryid": 1
    }
    ```

6. **Eliminar un producto**:
    - Método: `DELETE`
    - URL: `http://localhost:8080/api/products/1`

7. **Obtener productos filtrados por categoría**:
    - Método: `GET`
    - URL: `http://localhost:8080/api/products/category/1`

8. **Buscar un producto por ID**:
    - Método: `GET`
    - URL: `http://localhost:8080/api/products/1`
  
