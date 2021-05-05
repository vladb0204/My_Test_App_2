package myproject.kotlin.criminai_test_app_1

import androidx.lifecycle.ViewModel

class CrimeListViewModel : ViewModel() {

    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()

    public fun addCrime(crime: Crime) {
        crimeRepository.addCrime(crime)
    }
}