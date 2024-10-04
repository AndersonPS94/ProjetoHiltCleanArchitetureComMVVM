package com.example.projetomvvmcleanhilt.data.repository

import android.util.Log
import com.example.projetomvvmcleanhilt.data.dto.toUsuario
import com.example.projetomvvmcleanhilt.data.remote.DummyAPI
import com.example.projetomvvmcleanhilt.domain.model.Usuario
import com.example.projetomvvmcleanhilt.domain.repository.UsuarioRepository
import javax.inject.Inject

class UsuarioRepositoryimpl@Inject constructor(
  private val dummyAPI: DummyAPI
) : UsuarioRepository {
    override suspend fun recuperarUsuarios(): List<Usuario> {
        try {
            val resposta = dummyAPI.recuperarUsuarios()
            if (resposta.isSuccessful && resposta.body() != null) {
                val respostaAPIDTO = resposta.body()
                val listaUsuarios = respostaAPIDTO?.users
                if(listaUsuarios != null){
                    /*val usuarios = listaUsuarios.map {usuarioDTO ->
                        usuarioDTO.toUsuario()*/
                    return listaUsuarios.map {it.toUsuario() }
                }
            }else {
                Log.i("lista_usuarios", "${resposta.message()}")
            }
        } catch (erroRecyperarUsuarios: Exception){
            erroRecyperarUsuarios.printStackTrace()
        }
        return emptyList()
    }
}