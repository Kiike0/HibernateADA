// src/main/kotlin/com/ejemplo/Main.kt
package prog

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence

fun main() {
    //Parte ORM
    val entityManagerFactory: EntityManagerFactory = Persistence.createEntityManagerFactory("ejemplo")

    val entityManager: EntityManager = entityManagerFactory.createEntityManager()

    //SE CREAN LOS OBJETOS

    //RELACION One-to-Many
    val person = Person(name =  "Tom Hanks", age = 65)
    val animal = Animal(nameAnimal = "Yuri", propietario = person, tipo = "Gato")
    person.anadirMascota(animal)

    //RELACION One-to-One
    val direccion = Direccion(localidad = "Barcelona", pais = "España", direccion = "Calle La Roma")
    val empleado = Empleado(nombre = "Joaquín Reyes", direccion = direccion)

    //SE OPERA CON LA BASE DE DATOS Y LOS OBJETOS
    entityManager.transaction.begin()
    entityManager.persist(person)
    entityManager.persist(animal)
    entityManager.persist(direccion)
    entityManager.persist(empleado)
    entityManager.transaction.commit()

    //PARA LEER LOS RESULTADOS DE LA BASE DATOS
    val personas: List<Person> = entityManager.createQuery("FROM Person", Person::class.java).resultList
    println("Número de personas " + personas.size)

    println("Personas en la tabla:")
    for (p in personas) {
        println("ID: ${p.id}, Nombre: ${p.name}, Edad: ${p.age}")
    }

    val animales: List<Animal> = entityManager.createQuery("FROM Animal", Animal::class.java).resultList
    println("Número de animales " + animales.size)

    println("Animales en la tabla:")
    for (a in animales) {
        println("ID: ${a.idAnimal}, ID_Dueño:${a.propietario}, Nombre: ${a.nameAnimal}, Tipo: ${a.tipo}")
    }

    entityManager.close()
    entityManagerFactory.close()
}

/*
POR SI QUEREMOS COMPROBAR LA CONEXIÓN

class Conectar {
    fun connectToDatabase(): Connection? {
        try {
            // Paso 1: Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver")

            // Paso 2: Establecer la conexión
            val url = "jdbc:mysql://localhost:3306/prueba_hybernate"
            val user = "root"
            val password = "root"

            return DriverManager.getConnection(url, user, password)
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
            println("Error: No se pudo cargar el controlador JDBC.")
        } catch (e: SQLException) {
            e.printStackTrace()
            println("Error de conexión a la base de datos.")
        }

        return null
    }

}
*/