package com.cortez.renato.laboratoriocalificado03

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("list/teacher-b")
    suspend fun getTeachers(): Response<ListaProfesores>
}