package myproject.kotlin.criminai_test_app_1

import androidx.room.Dao
import androidx.room.Query
import java.util.*

@Dao
interface CrimeDao {

    @Query("SELECT * FROM crime")
    public fun getCrimes(): List<Crime>

    @Query("SELECT * FROM crime WHERE id=(:id)")
    public fun getCrime(id: UUID): Crime?
}