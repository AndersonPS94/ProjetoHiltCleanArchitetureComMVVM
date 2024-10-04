package com.example.projetomvvmcleanhilt.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.projetomvvmcleanhilt.databinding.ActivityMainBinding
import com.example.projetomvvmcleanhilt.presentation.viewmodel.UsuariosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val usuariosViewModel: UsuariosViewModel by viewModels()

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       // usuariosViewModel = ViewModelProvider(this).get(UsuariosViewModel::class.java)

        usuariosViewModel.usuarios.observe(this) { listaUsuarios ->
            var listaResultado = ""
            listaUsuarios.forEach {
                usuario ->
                val nome = usuario.nome
                val sobrenome = usuario.sobrenome
                val idade = usuario.idade
                val email = usuario.email
                val telefone = usuario.telefone
                val imagem = usuario.imagem
                listaResultado += "+) ${nome} - ${sobrenome} -  ${idade} -  ${email} -  ${telefone} -  ${imagem} \n"
            }
                binding.textResultado.text = listaResultado
        }
    }
}