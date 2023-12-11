package random.barnacle.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import random.barnacle.data.repository_implementations.PriceRepositoryImpl
import random.barnacle.data.repository_implementations.TokensRepositoryImpl
import random.barnacle.domain.repositories.PriceRepository
import random.barnacle.domain.repositories.TokensRepository
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
