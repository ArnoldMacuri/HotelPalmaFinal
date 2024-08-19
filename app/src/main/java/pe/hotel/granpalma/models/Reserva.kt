
package pe.hotel.granpalma.models

data class Reserva(
    val nombre: String,
    val telefono: String,
    val fecha: String,
    val servicios: List<String>
)