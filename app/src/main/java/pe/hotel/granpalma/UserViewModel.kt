package pe.hotel.granpalma.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pe.hotel.granpalma.retrofit.ApiService
import pe.hotel.granpalma.retrofit.RetrofitInstance
import pe.hotel.granpalma.retrofit.UserRequest
import pe.hotel.granpalma.retrofit.UserResponse
import retrofit2.Response
import retrofit2.awaitResponse

class UserViewModel : ViewModel() {

    private val apiService: ApiService = RetrofitInstance.api

    fun loginUser(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response: Response<UserResponse> = apiService.login(email, password).awaitResponse()
                if (response.isSuccessful) {
                    onSuccess()
                } else {
                    onError("Login failed: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                onError(e.localizedMessage ?: "Unknown error")
            }
        }
    }

    fun registerUser(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response: Response<UserResponse> = apiService.register(UserRequest(email, password)).awaitResponse()
                if (response.isSuccessful) {
                    onSuccess()
                } else {
                    onError("Registration failed: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                onError(e.localizedMessage ?: "Unknown error")
            }
        }
    }
}
