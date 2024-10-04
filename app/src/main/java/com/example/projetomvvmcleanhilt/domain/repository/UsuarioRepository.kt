package com.example.projetomvvmcleanhilt.domain.repository

import com.example.projetomvvmcleanhilt.domain.model.Usuario

interface UsuarioRepository {

    suspend fun recuperarUsuarios(): List<Usuario>
}