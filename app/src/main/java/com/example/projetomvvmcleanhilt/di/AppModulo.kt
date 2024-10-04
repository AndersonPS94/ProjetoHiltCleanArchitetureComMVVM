package com.example.projetomvvmcleanhilt.di

import com.example.projetomvvmcleanhilt.data.remote.DummyAPI
import com.example.projetomvvmcleanhilt.data.repository.UsuarioRepositoryimpl
import com.example.projetomvvmcleanhilt.domain.repository.UsuarioRepository
import com.example.projetomvvmcleanhilt.domain.usecase.GetUsuariosUseCase
import com.example.projetomvvmcleanhilt.util.Constantes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModulo {

    //provide
    @Provides
    fun proverRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    fun proverDummyAPI(retrofit: Retrofit): DummyAPI {
        return retrofit.create(DummyAPI::class.java)
    }

    @Provides
    fun proverUsuarioRepository(dummyAPI: DummyAPI):UsuarioRepository {
        return UsuarioRepositoryimpl(dummyAPI)
    }
    @Provides
    fun proverUsuariosUseCase(usuarioRepository: UsuarioRepository): GetUsuariosUseCase {
        return GetUsuariosUseCase(usuarioRepository)
    }
}