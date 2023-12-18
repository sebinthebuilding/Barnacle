package random.barnacle.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import random.barnacle.data.repositories.PriceRepository
import random.barnacle.data.repositories.PriceRepositoryImpl
import random.barnacle.data.repositories.TokensRepository
import random.barnacle.data.repositories.TokensRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTokensRepository(
        tokensRepositoryImpl: TokensRepositoryImpl
    ): TokensRepository

    @Binds
    @Singleton
    abstract fun bindPriceRepository(
        priceRepositoryImpl: PriceRepositoryImpl
    ): PriceRepository

}
