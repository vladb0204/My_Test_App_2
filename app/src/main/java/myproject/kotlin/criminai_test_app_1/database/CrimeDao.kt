package myproject.kotlin.criminai_test_app_1.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import myproject.kotlin.criminai_test_app_1.Crime
import java.util.*

@Dao
interface CrimeDao {

    @Query("SELECT * FROM crime")
    public fun getCrimes(): LiveData<List<Crime>>

    @Query("SELECT * FROM crime WHERE id=(:id)")
    public fun getCrime(id: UUID): LiveData<Crime?>

    @Update
    public fun updateCrime(crime: Crime)

    @Insert
    public fun addCrime(crime: Crime)
}