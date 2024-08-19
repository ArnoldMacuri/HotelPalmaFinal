package pe.hotel.granpalma.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    // Reemplaza "localhost" con la IP de tu máquina local si estás usando un emulador.
    // Para un dispositivo físico conectado al mismo Wi-Fi, usa la IP local de tu máquina.
    private const val BASE_URL = "http://10.0.2.2:8086" // Usa la IP y puerto correctos de tu servidor local

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
