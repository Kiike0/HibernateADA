package prog

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne

@Entity
data class Empleado(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idEmpleado: Long? = null,
    val nombre : String,
    @OneToOne
    @JoinColumn(name = "id_direccion")
    val direccion: Direccion
)

/*
@Entity
data class Empleado(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_EMPLEADO")
    private val codigo:Long?=null,

    @Column(name = "APELLIDOS")
    private val apellidos:String,

    @Column(name = "NOMBRE")
    private val nombre:String,

    @Column(name = "FECHA_NACIMIENTO")
    private val fechaNacimiento:LocalDate,

    @OneToOne
    @JoinColumn(name = "ID_DIRECCION")
    var direccion: Direccion?=null
){
}
*/
