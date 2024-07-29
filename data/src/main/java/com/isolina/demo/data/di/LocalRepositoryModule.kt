package com.isolina.demo.data.di

import com.isolina.demo.data.impl.LocalRepositoryImpl
import com.isolina.demo.data.repository.LocalRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalRepositoryModule {
    @Binds
    @Singleton
    internal abstract fun bindRepository(repository: LocalRepositoryImpl): LocalRepository

}