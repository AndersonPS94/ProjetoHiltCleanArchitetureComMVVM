package com.example.projetomvvmcleanhilt.data.remote

import com.example.projetomvvmcleanhilt.data.dto.ResultadoAPIDTO
import retrofit2.Response
import retrofit2.http.GET

interface DummyAPI {


    //https://dummyjson.com/users
    @GET("users")
    suspend fun recuperarUsuarios(): Response<ResultadoAPIDTO>



}