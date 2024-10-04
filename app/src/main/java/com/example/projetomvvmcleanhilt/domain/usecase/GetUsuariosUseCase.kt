package com.example.projetomvvmcleanhilt.domain.usecase

import com.example.projetomvvmcleanhilt.domain.model.Usuario
import com.example.projetomvvmcleanhilt.domain.repository.UsuarioRepository
import javax.inject.Inject

class GetUsuariosUseCase  @Inject constructor(
    private val usuarioRepository: UsuarioRepository
) {

    suspend operator fun invoke(): List<Usuario> {
        try {

            //regra de negocios
            return usuarioRepository.recuperarUsuarios()


        } catch (erroRecupperarUsuarios: Exception) {
            erroRecupperarUsuarios.printStackTrace()
            return emptyList()
        }
    }
}