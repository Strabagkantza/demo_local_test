package com.isolina.demo.data.local

import android.content.Context

interface DatabaseProvider {
    fun provideDatabase(context: Context): AppDatabase
}