package random.barnacle.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import random.barnacle.data.PriceApiService
import random.barnacle.data.TokenApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTokensApi(): TokenApiService {
        return Retrofit.Builder()
             .addConverterFactory(GsonConverterFactory.create())
             .baseUrl("https://token.jup.ag/")
             .build()
             .create()
    }

    @Provides
    @Singleton
    fun providePriceApi(): PriceApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://price.jup.ag/")
            .build()
            .create()
    }

}