package com.example.projetomvvmcleanhilt.data.dto

data class ResultadoAPIDTO(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<UsuarioDTO>
)