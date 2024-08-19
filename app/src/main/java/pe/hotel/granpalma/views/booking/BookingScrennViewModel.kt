package pe.hotel.granpalma.views.booking

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import pe.hotel.granpalma.models.Reserva

class BookingScreenViewModel : ViewModel() {
    val reservas = mutableStateListOf<Reserva>()

    fun addReserva(reserva: Reserva) {
        reservas.add(reserva)
    }
}