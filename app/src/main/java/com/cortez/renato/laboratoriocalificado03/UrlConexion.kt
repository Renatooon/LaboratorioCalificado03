package com.cortez.renato.laboratoriocalificado03

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UrlConexion {
    private const val BASE_URL = "https://private-effe28-tecsup1.apiary-mock.com/"

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }
}
