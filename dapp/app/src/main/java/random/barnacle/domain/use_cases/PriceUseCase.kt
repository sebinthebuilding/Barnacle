package random.barnacle.domain.use_cases

import random.barnacle.data.repositories.PriceRepository

class getPriceUseCase(private val priceRepository: PriceRepository) {
    val mSolTokenAddress: String = "mSoLzYCxHdYgdzU16g5QSh3i5K3z3KZK7ytfqcJm7So"

    /*
    suspend fun usdcPrice(): StateFlow<Double> {
        return priceRepository.getUsdcPrice(mSolTokenAddress)
    }
     */
}