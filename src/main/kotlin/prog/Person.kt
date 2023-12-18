package prog

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val age: Int
){
    @OneToMany(mappedBy = "propietario", cascade = [CascadeType.ALL])
    val mascotas : MutableList<Animal> = mutableListOf()

    fun anadirMascota(mascota:Animal){
        mascotas.add(mascota)
    }
}