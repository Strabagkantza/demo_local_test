package com.isolina.demo.usecases.di

import com.isolina.demo.usecases.LocalUseCase
import com.isolina.demo.usecases.impl.LocalUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalUseCaseModule {
    @Binds
    @Singleton
    internal abstract fun bindUseCase(localUseCaseImpl: LocalUseCaseImpl): LocalUseCase

}