package random.barnacle.di

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import com.solana.mobilewalletadapter.clientlib.ConnectionIdentity
import com.solana.mobilewalletadapter.clientlib.MobileWalletAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import random.barnacle.data.PriceApiService
import random.barnacle.data.TokenApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
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

val solanaUri = Uri.parse("https://solana.com")
val iconUri = Uri.parse("favicon.ico")
val identityName = "Solana"

@InstallIn(ViewModelComponent::class)
@Module
class Web3AppModule {

    @Provides
    fun providesSharedPreferences(@ApplicationContext ctx: Context): SharedPreferences {
        return ctx.getSharedPreferences("barnacle_preferences", Context.MODE_PRIVATE)
    }

    @Provides
    fun providesMobileWalletAdapter(): MobileWalletAdapter {
        return MobileWalletAdapter(
            connectionIdentity = ConnectionIdentity(
                identityUri = solanaUri,
                iconUri = iconUri,
                identityName = identityName
            )
        )
    }
}