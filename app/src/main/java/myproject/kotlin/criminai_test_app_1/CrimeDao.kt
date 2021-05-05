package myproject.kotlin.criminai_test_app_1

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import java.util.*

@Dao
interface CrimeDao {

    @Query("SELECT * FROM crime")
    public fun getCrimes(): LiveData<List<Crime>>

    @Query("SELECT * FROM crime WHERE id=(:id)")
    public fun getCrime(id: UUID): LiveData<Crime?>

    @Update
    public fun updateCrime(crime: Crime)

    @Update
    public fun addCrime(crime: Crime)
}