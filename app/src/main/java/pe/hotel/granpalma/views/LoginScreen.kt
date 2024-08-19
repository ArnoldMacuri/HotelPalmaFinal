package pe.hotel.granpalma.views.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pe.hotel.granpalma.R
import pe.hotel.granpalma.viewmodel.UserViewModel

@Composable
fun LoginScreen(navController: NavController) {
    val userViewModel: UserViewModel = viewModel()
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo), // Reemplaza con tu logo
            contentDescription = "Logo",
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "INICIA SESIÓN",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Username Field
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.usuario), // Reemplaza con tu ícono de usuario
                    contentDescription = "User Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF7ED321))
                        .padding(8.dp)
                )
            },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth(0.85f) // Ajusta el ancho de los campos
                .height(60.dp)
                .clip(RoundedCornerShape(30.dp)), // Borde redondeado
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF5F5F5),
                unfocusedContainerColor = Color(0xFFF5F5F5),
                disabledContainerColor = Color(0xFFF5F5F5),
                focusedBorderColor = Color.Transparent,  // Borde transparente
                unfocusedBorderColor = Color.Transparent  // Borde transparente sin foco
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.tl), // Reemplaza con tu ícono de lock
                    contentDescription = "Password Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF7ED321))
                        .padding(8.dp)
                )
            },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(60.dp)
                .clip(RoundedCornerShape(30.dp)), // Borde redondeado
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF5F5F5),
                unfocusedContainerColor = Color(0xFFF5F5F5),
                disabledContainerColor = Color(0xFFF5F5F5),
                focusedBorderColor = Color.Transparent,  // Borde transparente
                unfocusedBorderColor = Color.Transparent  // Borde transparente sin foco
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Login Button
        Button(
            onClick = {
                userViewModel.loginUser(
                    email = username,
                    password = password,
                    onSuccess = {
                        navController.navigate("welcome")
                    },
                    onError = { errorMessage -> message = errorMessage }
                )
            },
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(56.dp)
                .clip(RoundedCornerShape(30.dp)), // Borde redondeado para el botón
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF7ED321) // Color del fondo del botón
            )
        ) {
            Text(text = "LOGIN", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Register Text
        Text(
            text = " REGÍSTRATE",
            fontSize = 14.sp,
            color = Color(0xFF007AFF),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            textDecoration = TextDecoration.Underline
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (message.isNotEmpty()) {
            Text(text = message, color = Color.Red, textAlign = TextAlign.Center)
        }
    }
}
