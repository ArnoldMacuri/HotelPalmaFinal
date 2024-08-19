package pe.hotel.granpalma.views.booking

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pe.hotel.granpalma.R
import pe.hotel.granpalma.models.Reserva

import pe.hotel.granpalma.views.reservation.ReservationViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(
    navController: NavController,
    hotelName: String,
    viewModel: ReservationViewModel
) {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var services by remember { mutableStateOf(listOf("Room Service", "Breakfast", "WiFi")) }
    var selectedServices by remember { mutableStateOf(emptyList<String>()) }
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tu Reserva en $hotelName", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                // Campo para el nombre
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nombre Completo") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_24_7),
                            contentDescription = "Nombre"
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Campo para el teléfono
                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = { Text("Número Telefónico") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_fitness_center),
                            contentDescription = "Teléfono"
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Campo para la fecha
                OutlinedTextField(
                    value = date,
                    onValueChange = { date = it },
                    label = { Text("Fecha de Reservación") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_calendar),
                            contentDescription = "Fecha"
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Selección de servicios adicionales
                Text(
                    text = "Selecciona Servicios Adicionales:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                services.forEach { service ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        Checkbox(
                            checked = selectedServices.contains(service),
                            onCheckedChange = {
                                if (it) {
                                    selectedServices = selectedServices + service
                                } else {
                                    selectedServices = selectedServices - service
                                }
                            }
                        )
                        Text(text = service)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Botón de confirmación de reserva
                Button(
                    onClick = {
                        // Guardar la reserva en el ViewModel
                        val reserva = Reserva(name, phone, date, selectedServices)
                        viewModel.addReserva(reserva)

                        showDialog = true // Muestra el diálogo de confirmación
                    },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Confirmar Reserva", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "El pago se realizará el día de la visita al hospedaje.",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Diálogo de confirmación
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = {
                        showDialog = false
                    },
                    confirmButton = {
                        TextButton(onClick = {
                            showDialog = false
                            navController.popBackStack() // Acción al confirmar
                        }) {
                            Text("OK", fontWeight = FontWeight.Bold)
                        }
                    },
                    text = {
                        Text("Reserva realizada con éxito", fontSize = 16.sp)
                    }
                )
            }
        }
    )
}