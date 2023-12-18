package prog

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Direccion(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idDireccion: Long? = null,
        val localidad : String,
        val pais : String,
        val direccion : String
)

/*
@Entity
@Table(name = "DIRECCION")
data class Direccion (

        @Id
        @Column(name = "ID_DIRECCION")
        private val iddireccion:Int,
        @Column(name = "DIRECCION")
        private val nombredireccion:String,
        @Column(name = "LOCALIDAD")
        private val localidad:String,
)
*/