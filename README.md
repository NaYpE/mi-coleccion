# Mi Colección

&#x20;

Este proyecto es una implementación de una **colección dinámica en Java**. Permite **agregar, eliminar, buscar y obtener elementos** de manera eficiente.

## 🚀 **Características principales**

👉 **Uso de genéricos** para garantizar type-safety.\
👉 **Capacidad dinámica**, el arreglo interno crece y se reduce automáticamente.\
👉 **Métodos eficientes** para insertar, eliminar, buscar y obtener elementos.\
👉 **Compatible con JUnit 5** para pruebas automatizadas.\
👉 **Dockerizado** para fácil despliegue y ejecución.

---

## 📀 **Cómo usar**

### 🔹 **Requisitos**

- **Java 21**: Asegúrate de tener **JDK 21** instalado.
- **Maven**: Para gestionar dependencias y construir el proyecto.
- **Docker (Opcional)**: Para ejecutar la aplicación en un contenedor.

### 🔹 **Clonar el repositorio**

```bash
git clone https://github.com/NaYpE/mi-coleccion.git
cd mi-coleccion
```

---

## ⚙ **Compilar y Ejecutar**

### 🔹 **Ejecutar con Maven**

```bash
mvn clean package
java -jar target/mi-coleccion-1.0-SNAPSHOT.jar
```

### 🔹 **Ejecutar con Docker**

```bash
docker build -t mi-coleccion .
docker run -p 8080:8080 mi-coleccion
```

---

## 🤖 **Ejecutar Pruebas**

### 🔹 **Correr pruebas con Maven**

```bash
mvn test
```

### 🔹 **Generar Reporte de Cobertura con JaCoCo**

```bash
mvn clean verify
```

Después, puedes ver el reporte de cobertura en:

```
target/site/jacoco/index.html
```

---

## 🛠 **Estructura del Proyecto**

```
mi-coleccion/
│── src/
│   ├── main/java/com/naype/micoleccion/   # Código fuente
│   └── test/java/com/naype/micoleccion/   # Pruebas unitarias
│── target/                                 # Archivos generados por Maven
│── Dockerfile                              # Configuración para Docker
│── pom.xml                                 # Configuración de Maven
│── README.md                               # Documentación
```

---

## 📚 **Contribuir**

Si deseas contribuir, por favor sigue estos pasos:

1. **Haz un fork** del repositorio.
2. **Crea una rama** con una nueva característica:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. **Realiza tus cambios** y confirma:
   ```bash
   git commit -m "Agregada nueva funcionalidad"
   ```
4. **Sube los cambios**:
   ```bash
   git push origin feature/nueva-funcionalidad
   ```
5. **Crea un Pull Request** 🚀

---

## 🧑‍💻 Autor

👤 **NaYpE**  
📌 [GitHub](https://github.com/NaYpE) | 📌 [LinkedIn](https://www.linkedin.com/in/angelcastrogonzalez/)  

