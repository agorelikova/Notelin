package com.imangazaliev.notelin.di

import com.imangazaliev.notelin.mvp.model.APIClient
import com.imangazaliev.notelin.mvp.model.APIInterface
import dagger.Module
import dagger.Provides
import com.imangazaliev.notelin.mvp.model.NoteDao
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NoteDaoModule {

    @Provides
    @Singleton
    fun provideNoteDao(): NoteDao = NoteDao()

    @Provides
    @Singleton
    fun provideAPIClient(): APIInterface = APIClient.getClient().create(APIInterface::class.java)

}