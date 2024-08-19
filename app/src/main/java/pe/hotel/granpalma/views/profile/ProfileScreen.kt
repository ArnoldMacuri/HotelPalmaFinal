package pe.hotel.granpalma.views.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import pe.hotel.granpalma.R

@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Encabezado con el logo y el título de "Profile"
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_logo_letter),
                    contentDescription = "Logo",
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Profile",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Imagen de perfil con un botón para editar
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_avatar),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_edit),
                        contentDescription = "Edit Profile",
                        tint = Color.Green
                    )
                }
            }

            // Items del menú del perfil
            MenuItem(iconResId = R.drawable.ic_profile_border, title = "Edit Profile")
            MenuItem(iconResId = R.drawable.ic_wallet_border, title = "Payment")
            MenuItem(iconResId = R.drawable.ic_notification_border, title = "Notifications")
            MenuItem(iconResId = R.drawable.ic_shield_done_border, title = "Security")
            MenuItem(iconResId = R.drawable.ic_info_square_border, title = "Help")

            // Interruptor de tema oscuro
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_show_border),
                    contentDescription = "Dark Theme"
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Dark Theme", modifier = Modifier.weight(1f))
                Switch(
                    checked = false,
                    onCheckedChange = { /* Acción de cambio de tema */ }
                )
            }

            // Botón de Logout
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { /* Acción de cerrar sesión */ }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_logout_border),
                    contentDescription = "Logout"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Logout",
                    color = Color.Red
                )
            }
        }
    }
}

@Composable
fun MenuItem(iconResId: Int, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { /* Acción del item */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = title,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title)
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    var selectedIndex by rememberSaveable { mutableStateOf(3) }
    NavigationBar {
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home_border),
                    contentDescription = "Home"
                )
            },
            selected = selectedIndex == 0,
            onClick = {
                selectedIndex = 0
                navController.navigate("home")
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search_border),
                    contentDescription = "Search"
                )
            },
            selected = selectedIndex == 1,
            onClick = {
                selectedIndex = 1
                // Aquí puedes navegar a la pantalla de búsqueda
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_document_border),
                    contentDescription = "Booking"
                )
            },
            selected = selectedIndex == 2,
            onClick = {
                selectedIndex = 2
                // Aquí puedes navegar a la pantalla de reservas
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Profile"
                )
            },
            selected = selectedIndex == 3,
            onClick = { selectedIndex = 3 }
        )
    }
}
