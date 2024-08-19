package pe.hotel.granpalma.views.reservation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.hotel.granpalma.models.Reserva

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReservationsScreen(viewModel: ReservationViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mis Reservas", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        content = { paddingValues ->
            if (viewModel.reservas.isEmpty()) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    Text(
                        text = "No hay reservas aún.",
                        fontSize = 18.sp,
                        color = Color.Gray
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp)
                ) {
                    items(viewModel.reservas) { reserva ->
                        ReservaItem(reserva)
                    }
                }
            }
        }
    )
}

@Composable
fun ReservaItem(reserva: Reserva) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = reserva.nombre, style = MaterialTheme.typography.bodyMedium)
            Text(text = "Teléfono: ${reserva.telefono}")
            Text(text = "Fecha: ${reserva.fecha}")
            Text(text = "Servicios: ${reserva.servicios.joinToString()}")
        }
    }
}