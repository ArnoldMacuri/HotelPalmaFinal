@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package pe.hotel.granpalma.views.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import pe.hotel.granpalma.R
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hello, Makanaki 👋", fontSize = 24.sp, fontWeight = FontWeight.Bold) },
                actions = {
                    IconButton(onClick = { navController.navigate("notifications_screen") }) {
                        Icon(
                            painterResource(id = R.drawable.ic_notification_border),
                            contentDescription = "Notificaciones"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painterResource(id = R.drawable.ic_bookmark),
                            contentDescription = "Profile"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = "", // Aquí va el valor del texto de búsqueda
                    onValueChange = {},
                    placeholder = {
                        Text(text = "Search", fontSize = 18.sp, color = Color.Gray)
                    },
                    leadingIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_search),
                            contentDescription = "Search Icon",
                            modifier = Modifier
                                .padding(vertical = 2.dp)
                                .size(20.dp)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .background(Color(0xFFFFFFFF), RoundedCornerShape(8.dp)),
                    textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        cursorColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    item {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp)),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF4CAF50),
                                contentColor = Color.White
                            )
                        ) {
                            Text("Recommended")
                        }
                    }
                    item {
                        OutlinedButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp)),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = Color.Gray
                            ),
                            border = BorderStroke(1.dp, Color.Gray)
                        ) {
                            Text("Popular")
                        }
                    }
                    item {
                        OutlinedButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp)),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = Color.Gray
                            ),
                            border = BorderStroke(1.dp, Color.Gray)
                        ) {
                            Text("Trending")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    item {
                        HotelCard(
                            imageRes = R.drawable.img_carousel_1,
                            hotelName = "Gran Palma Hotel",
                            location = "Chilca, Huancayo",
                            price = "$29 / per night",
                            onClick = {
                                navController.navigate(
                                    "room_detail_screen/Gran Palma Hotel/Chilca, Huancayo/29/${R.drawable.img_carousel_1}"
                                )
                            }
                        )
                    }
                    item {
                        HotelCard(
                            imageRes = R.drawable.img_carousel_2,
                            hotelName = "Gran Palma Hotel",
                            location = "Piura, Santiago",
                            price = "$32 / per night",
                            onClick = {
                                navController.navigate(
                                    "room_detail_screen/Gran Palma Hotel/Piura, Santiago/32/${R.drawable.img_carousel_2}"
                                )
                            }
                        )
                    }
                    item {
                        HotelCard(
                            imageRes = R.drawable.img_carousel_3,
                            hotelName = "Gran Palma Hotel",
                            location = "Paracas, Paracas",
                            price = "$32 / per night",
                            onClick = {
                                navController.navigate("room_detail_screen/Gran Palma Hotel/Piura, Santiago/$32/R.drawable.img_carousel_2")
                            }
                        )
                    }
                    item {
                        HotelCard(
                            imageRes = R.drawable.habitacion_1,
                            hotelName = "Gran Palma Hotel",
                            location = "Talara, Piura",
                            price = "$32 / per night",
                            onClick = {
                                navController.navigate("room_detail_screen/Gran Palma Hotel/Piura, Santiago/$32/R.drawable.img_carousel_2")
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    item {
                        RecentlyBookedHotelCard(
                            hotelName = "President Hotel",
                            location = "Chilca, Huancayo",
                            price = "$35 / night",
                            rating = 4.8f
                        )
                    }
                    item {
                        RecentlyBookedHotelCard(
                            hotelName = "Palms Casino",
                            location = "Piura, Santiago",
                            price = "$29 / night",
                            rating = 4.9f
                        )
                    }
                    item {
                        RecentlyBookedHotelCard(
                            hotelName = "Palazzo Versace",
                            location = "Paracas, Paracas",
                            price = "$36 / night",
                            rating = 4.7f
                        )
                    }
                    item {
                        RecentlyBookedHotelCard(
                            hotelName = "Palazzo Versace",
                            location = "Paracas, Paracas",
                            price = "$36 / night",
                            rating = 4.7f
                        )
                    }
                }
            }
        },
        bottomBar = {
            BottomNavigation  {

                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    selected = true,
                    onClick = { /*TODO*/ }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Book, contentDescription = "Reservas") },
                    selected = false,
                    onClick = { // Navegar a la pantalla de reservas
                        navController.navigate("reservation_screen") }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    selected = false,

                    onClick = {
                        // Aquí se navega a la nueva pantalla
                        navController.navigate("profile_screen")
                    }

                )

            }
        }
    )
}

@Composable
fun HotelCard(
    imageRes: Int,
    hotelName: String,
    location: String,
    price: String,
    onClick: () -> Unit // Se añade el onClick
) {
    Card(
        modifier = Modifier
            .width(220.dp)
            .height(280.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick), // Se implementa el onClick
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Hotel Image",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            ) {
                Text(
                    text = hotelName,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = location,
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = price,
                    fontWeight = FontWeight.Bold,
                    color = Color.Green
                )
            }
        }
    }
}

@Composable
fun RecentlyBookedHotelCard(
    hotelName: String,
    location: String,
    price: String,
    rating: Float
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.habit), // Reemplaza con la imagen correcta
                    contentDescription = "Hotel Image",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = hotelName,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = location,
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = null,
                            tint = Color.Yellow,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "$rating ",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "(⭐ reviews)",
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                    }
                }
            }
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "$price\n/night", // Aquí agregamos el salto de línea
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color(0xFF4CAF50),
                    textAlign = TextAlign.End
                )
                Spacer(modifier = Modifier.height(4.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_bookmark),
                    contentDescription = null,
                    tint = Color(0xFF4CAF50),
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}