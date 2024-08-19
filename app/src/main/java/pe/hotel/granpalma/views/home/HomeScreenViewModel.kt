package pe.hotel.granpalma.views.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.hotel.granpalma.data.Hotel

class HomeViewModel : ViewModel() {

    private val _hotelList = MutableStateFlow<List<Hotel>>(emptyList())
    val hotelList: StateFlow<List<Hotel>> = _hotelList

    init {
        loadHotels()
    }

    private fun loadHotels() {
        // Simula la carga de datos de un repositorio o API
        viewModelScope.launch {
            val hotels = listOf(
                Hotel(id = "1", name = "Hotel A", location = "Lima, Peru", price = 120.0, imageUrl = "https://example.com/hotelA.jpg"),
                Hotel(id = "2", name = "Hotel B", location = "Cusco, Peru", price = 200.0, imageUrl = "https://example.com/hotelB.jpg")
                // Agrega más hoteles aquí
            )
            _hotelList.value = hotels
        }
    }
}