package pe.hotel.granpalma.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("/api/usuarios/registro")
    fun register(@Body request: UserRequest): Call<UserResponse>

    @POST("/api/usuarios/login")
    fun login(@Query("email") email: String, @Query("password") password: String): Call<UserResponse>
}


