package random.barnacle.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solana.mobilewalletadapter.clientlib.MobileWalletAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import random.barnacle.data.repositories.PriceRepository
import random.barnacle.data.repositories.TokensRepository
import random.barnacle.domain.QuoteCurrencies
import random.barnacle.domain.models.TokenModel
import random.barnacle.domain.use_cases.PersistenceUseCase
import javax.inject.Inject

data class MainViewState(
    val isLoading: Boolean = false,
    val canTransact: Boolean = false,
    val solBalance: Double = 0.0,
    val userAddress: String = "TEST",
    val userLabel: String = "",
    val walletFound: Boolean = true
)

@HiltViewModel
class AppViewModel @Inject constructor(
    private val walletAdapter: MobileWalletAdapter,
    private val persistenceUseCase: PersistenceUseCase,

    private val tokensRepository: TokensRepository,
    private val priceRepository: PriceRepository
): ViewModel() {

    private fun MainViewState.updateViewState() {
        _state.update { this }
    }

    private val _state = MutableStateFlow(MainViewState())

    val viewState: StateFlow<MainViewState>
        get() = _state

    val fakeState = MainViewState()

    var allTokensUiState: List<TokenModel> = emptyList()

    val allPricesUiState: MutableStateFlow<Map<String, Double>> = MutableStateFlow<Map<String, Double>>(emptyMap())
    var selectedQuoteCurrency by mutableStateOf(QuoteCurrencies.USDC)
        private set

    fun selectQuoteCurrency(quoteCurrency: QuoteCurrencies) {
        selectedQuoteCurrency = quoteCurrency
    }

    init {
        getUiState()
        priceStream(allAddresses = "EPjFWdd5AufqSSqeM2qN1xzybapC8G4wEGGkZwyTDt1v,So11111111111111111111111111111111111111112,Es9vMFrzaCERmJfrF4H2FYD4KCoNkY11McCe8BenwNYB,DezXAZ8z7PnrnRJjz3wXBoRgixCa6xjnB7YaB1pPB263,jtojtomepa8beP8AuQc6eXt5FriJwfFMwQx2v2f9mCL,mSoLzYCxHdYgdzU16g5QSh3i5K3z3KZK7ytfqcJm7So,bSo13r4TkiE4KumL71LsHTPpL2euBYLFx6h9HP3piy1,J1toso1uCk3RLmjorhTtrVwY9HJ7X8V9yYac6Y7kGCPn,orcaEKTdK7LKz57vaAYr9QeNsVEPfiu6QeMU1kektZE,HZ1JovNiVvGrGNiiYvEozEVgZ58xaU3RKwX8eACQBCt3,7vfCXTUXx5WJV5JADk17DUJ4ksgau7utNKj4b963voxs,A9mUU4qviSctJVPJdBJWkb28deg915LYJKrzQ19ji3FM,n54ZwXEcLnc3o7zK48nhrLV4KTU5wWD4iq7Gvdt5tik,AZsHEMXd36Bj1EMNXhowJajpUXzrKcK57wW4ZGXVa7yR,4k3Dyjzvzp8eMZWUXbBCjEvwSkkk59S5iCNLY3QrkX6R,27G8MtK7VtTcCHkpASjSDdkWWYfoqT6ggEuKidVJidD4,7kbnvuGBxxj8AG9qp8Scn56muWGaRaFqxg1FsRp3PaFT,LSTxxxnJzKDFSLr4dUkPcmCf5VyryEqzPLz5j4bpxFp,MNDEFzGvMt87ueuHvVU9VcTqsAP5b3fTGPsHuuPA5ey,HhJpBhRRn4g56VsyLuT8DL5Bv31HkXqsrahTTUCZeZg4,5yxNbU8DgYJZNi3mPD9rs4XLh9ckXrhPjJ5VCujUWg5H,hntyVP6YFm1Hg25TN9WGLqM12b8TQmcknKrdu1oxWux,BLZEEuZUBVqFhj8adcCFPJvPVCiCyVmh3hkJMrU8KuJA,SHDWyBxihqiCj6YekG2GUr7wqKLeLAMK1gHZck9pL6y,4vMsoUT2BWatFweudnQM1xedRLfJgJ7hswhcpz4xgBTy,7xKXtg2CW87d97TXJSDpbD5jBkheTqA83TZRuJosgAsU,HAxCJjnmgkdXhwZYeJiUvBgm4NdQvqhGJCS3KxCnCxWs,7dHbWXmci3dT8UFYWYZweBLXgycu7Y3iL6trKn1Y7ARj,5ritAPtFPqQtEFHcHVqNjR5oFNUJqcmgKtZyPd2AyLLy,nosXBVoaCTtYdLvKY6Csb4AC8JCdQKKAaWYtx2ZMoo7,GDfnEsia2WLAW5t8yx2X5j2mkfA74i5kwGdDuZHt7XmG,EKpQGSJtjMFqKZ9KQanSqYXRcF8fBopzLHYxdM65zcjm,USDH1SM1ojwWUga67PGrgFWUHibbjqMvuMaDkRJTgkX,SNSNkV9zfG5ZKWQs6x4hxvBRV6s8SqMfSGCtECDvdMd,GzQzkt2B4Jr6whWVBF7XqkzWvoUy1jEd5z9tczzGg1rH,CSD6JQMvLi46psjHdpfFdr826mF336pEVMJgjwcoS1m4,PumPRGmZ56t3Vngxo6fCP7ZJQ14oUg3biKxXrEyQBSf,81JNJJsL2qUEJAxCXBMAFJTzy42dSUKEHixrz1p7PaGY,rndrizKT3MK1iimdxRdWabcF7Zg7AR5T4nud4EkHBof,3NZ9JMVBmGAqocybic2c7LQCJScmgsAZ6vQqTDzcqmJh,RLBxxFkseAZ4RgJH3Sqn8jXxhmGoz9jWxDNJMh8pL7a,AURYydfxJib1ZkTir1Jn1J9ECYUtjb6rKQVmtYaixWPP,ATLASXmbPQxBUYbxPsV97usA3fPQYEqzQBUHgiFCUsXx,NeonTjSjsuo3rexg9o6vHuMXw62f9V7zvmu8M8Zut44,2ZE6hSL36e44wP168YMnxrbi1CSCFuD2BJm7NoNHfsmN,mb1eu7TzEc71KxDpsmsKoucSSuuoGLv1drys1oP2jh6,SCSuPPNUSypLBsV4darsrYNg4ANPgaGhKhsA3GmMyjz,HeqCcMjmuV5s25J49YiJyT6bD5qWLkP88YPajBySniaV,HBB111SCo9jkCejsZfz8Ec8nH7T6THF8KEKSnvwT6XK6,65nTNuJGHme4PQvKQyJykKp1bJAkK4A8Q66sd2yBWugf,poLisWXnNRwC6oBu1vHiuKQzFjGL4XDSu4g9qjz9qVk,J5qm3bYSuhaUU4WuGD32CcnzwTgTTyWLrwKJP8YWjkbs,METAewgxyPbgwsseH8T16a39CQ5VyVxZi9zXiDPY18m,SRMuApVNdxXokk5GT7XD5cUUgXMBCoAz2LHeuAoKWRt,BKipkearSqAUdNKa1WDstvcMjoPsSKBuNyvKDQDDu9WE,FLUXBmPhT3Fd1EDVFdg46YREqHBeNypn1h4EbnTzWERX,4icEZCrEYNop2ZaMMCkRHaNzkt6xG9BpijMCQV7mpw6Z,Dx1Lq5FjangW5ifRMEogAiakm24LyB5AoHmQifepvNjV,Dn4noZ5jgGfkntzcQSUZ8czkreiZ1ForXYoV2H8Dm7S1,iotEVVZLEywoTn1QdwNPddxPWszn3zFhEot3MfL9fns,Cx9oLynYgC3RrgXzin7U417hNY9D6YB1eMGw4ZMbWJgw,Saber2gLauYim4Mvftnrasomsv6NvAuncvMEZwcLpD1,6DSqVXg9WLTWgz6LACqxN757QdHe1sCqkUfojWmxWtok,7i5KKsX2weiTkry7jA4ZwSuXGhs5eJBEjY8vVxR4pfRx,7usVzynPTUJ9czdS96ezm9C6Z3hCsjb7j6TMKipURyyQ,MELLd8PyFoeNW3D5VaUe7L96eZeihtrzgLWrbKz5DR2,5goWRao6a3yNC4d6UjMdQxonkCMvKBwdpubU3qhfcdf1,J4ywFdm8H7hjwKzCaEQujhkDRfCnRviVnHMvFNDAoLNQ,H7ed7UgcLp3ax4X1CQ5WuWDn6d1pprfMMYiv5ejwLWWU,8PEca3rCa5pMUFSWAXvpAVjj4CgSzBtYiSyY4v9Yagnw,3bRTivrVsitbmCTGtqwp7hxXPsybkjn4XLNtPsHqa3zR,xxxxa1sKNGwFtw2kFn8XauW9xq8hBZ5kVtcSesTT9fW,3J5QaP1zJN9yXE7jr5XJa3Lq2TyGHSHu2wssK7N1Aw4p,9nEqaUcb16sQ3Tn1psbkWqyhPdLmfHWjKGymREjsAgTE,3EagcZ66c8z2hZdFSd5412yEW9U48AAb9P6d1yhjuGmY,StepAscQoEioFxxWGnh2sLBDFp9d8rvKz2Yp39iDpyT,6VHL2vMKgrF1YQFSv29Rs1pj9VCRK29bD11NtDqerqHA,4Ub7UHGZNpUcpGq9sWNbm7khpRD31hBYP9rtiqWopCcr,FmQ7v2QUqXVVtAXkngBh3Mwx7s3mKT55nQ5Z673dURYS,RKT69NZHN5uovcan3q5hRbZzfJuXiGEuPmGANoBJLLz,GFX1ZjR2P15tmrSwow6FjyDYcEkoFb4p4gJCpLBjaxHD,3dgCCb15HMQSA4Pn3Tfii5vRk7aRqTH95LJjxzsG2Mug,kinXdEcpDQeHPEuQnqmUgtYykqKGVFq6CeVX5iAHJq6,4wjPQJ6PrkC4dHhYghwJzGBVP78DkBzA2U3kHoFNBuhj,74DSHnK1qqr4z1pXjLjPAVi8XFngZ635jEVpdkJtnizQ,EchesyfXePKdLtoiZSL8pBe8Myagyy8ZRqsACNCFGnvp,8mq2np5SgMpJxZeNXjeoVYvjNWAnGKhYJU2Xj4GxFz5Q,LFNTYraetVioAPnGJht4yNg2aUZFXR776cMeN9VMjXp,HCgybxq5Upy8Mccihrp7EsmwwFqYZtrHrsmsKwtGXLgW,HxRELUQfvvjToVbacjr9YECdfQMUqGgPYB68jVDYxkbr,2g4C2KRA2VFsW5TtQokMwDwbuTtRKm1y89C2")
    }

    private fun getUiState() {
        viewModelScope.launch {
            allTokensUiState = tokensRepository.gimmeAllTokens()
        }
    }

    private fun priceStream(allAddresses: String) {
        viewModelScope.launch {
            while (true) {
                val allPrices = priceRepository.gimmeAllPrices(allAddresses, selectedQuoteCurrency.address)
                allPricesUiState.emit(allPrices)
            }
        }
    }

    fun stopPriceStream() {
        viewModelScope.coroutineContext.cancelChildren()
    }
}
