package com.example.projetomvvmcleanhilt.data.repository

import com.example.projetomvvmcleanhilt.data.remote.DummyAPI
import com.example.projetomvvmcleanhilt.domain.model.Usuario
import com.example.projetomvvmcleanhilt.domain.repository.UsuarioRepository
import javax.inject.Inject

class UsuarioRepositoryimpl@Inject constructor(
    val dummyAPI: DummyAPI
) : UsuarioRepository {
    override suspend fun rexccuperarUsuarios(): List<Usuario> {
        return emptyList()
    }
}