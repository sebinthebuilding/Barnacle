package random.barnacle.domain.use_cases

import android.content.SharedPreferences
import javax.inject.Inject

class PersistenceUseCase @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {

}