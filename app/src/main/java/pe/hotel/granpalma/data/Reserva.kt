package pe.hotel.granpalma.data

data class Reserva(
    val nombre: String,
    val telefono: String,
    val fecha: String,
    val servicios: List<String>
)