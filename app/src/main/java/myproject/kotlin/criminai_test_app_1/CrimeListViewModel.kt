package myproject.kotlin.criminai_test_app_1

import androidx.lifecycle.ViewModel

class CrimeListViewModel : ViewModel() {

    val crimes = mutableListOf<Crime>()

    init {
        for (index in 0 until 100) {
            val crime = Crime()
            crime.title = "Crime #$index"
            crime.isSolved = (index % 2 == 0)
            crimes += crime
        }
    }
}