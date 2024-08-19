package pe.hotel.granpalma.views.reservation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import pe.hotel.granpalma.models.Reserva

class ReservationViewModel : ViewModel() {
    val reservas = mutableStateListOf<Reserva>()

    fun addReserva(reserva: Reserva) {
        reservas.add(reserva)
    }
}