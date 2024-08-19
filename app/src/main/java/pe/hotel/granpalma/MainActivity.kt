package pe.hotel.granpalma


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.hotel.granpalma.ui.theme.GranPalmaTheme

import pe.hotel.granpalma.views.WelcomeScreen
import pe.hotel.granpalma.views.booking.BookingScreen
import pe.hotel.granpalma.views.home.HomeScreen
import pe.hotel.granpalma.views.home.LoginScreen

import pe.hotel.granpalma.views.profile.ProfileScreen
import pe.hotel.granpalma.views.reservation.ReservationViewModel
import pe.hotel.granpalma.views.reservation.ReservationsScreen


import pe.hotel.granpalma.views.room.RoomDetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GranPalmaTheme {
                val navController = rememberNavController()
                val reservationViewModel: ReservationViewModel = viewModel()


                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginScreen(navController = navController)
                    }
                    composable("welcome") {
                        WelcomeScreen(navController = navController)
                    }
                    composable("home") {
                        HomeScreen(navController = navController)
                    }
                    composable("profile_screen") {
                        ProfileScreen(navController = navController)
                    }
                    // Nueva ruta para RoomDetailScreen
                    composable(
                        "room_detail_screen/{hotelName}/{location}/{price}/{imageRes}",
                        arguments = listOf(
                            navArgument("hotelName") { type = NavType.StringType },
                            navArgument("location") { type = NavType.StringType },
                            navArgument("price") { type = NavType.StringType },
                            navArgument("imageRes") { type = NavType.IntType }
                        )
                    ) { backStackEntry ->
                        val hotelName = backStackEntry.arguments?.getString("hotelName") ?: ""
                        val location = backStackEntry.arguments?.getString("location") ?: ""
                        val price = backStackEntry.arguments?.getString("price") ?: ""
                        val imageRes = backStackEntry.arguments?.getInt("imageRes")
                            ?: R.drawable.ic_launcher_background

                        RoomDetailScreen(
                            navController = navController,
                            hotelName = hotelName,
                            location = location,
                            price = price,
                            imageRes = imageRes
                        )
                    }
                    // Nueva ruta para BookingScreen
                    composable(
                        "booking_screen/{hotelName}",
                        arguments = listOf(
                            navArgument("hotelName") { type = NavType.StringType }
                        )
                    ) { backStackEntry ->
                        val hotelName = backStackEntry.arguments?.getString("hotelName") ?: ""
                        BookingScreen(navController = navController, hotelName = hotelName, viewModel = reservationViewModel)
                    }
                    composable("reservations_screen") {
                        ReservationsScreen(viewModel = reservationViewModel)
                    }


                }
            }
        }
    }
}

