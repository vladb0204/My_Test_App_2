    package myproject.kotlin.criminai_test_app_1

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import myproject.kotlin.criminai_test_app_1.database.CrimeDatabase
import myproject.kotlin.criminai_test_app_1.database.migration_2_3
import java.io.File
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "crime-database"

class CrimeRepository private constructor(context: Context) {

    private val database : CrimeDatabase = Room.databaseBuilder(context.applicationContext,
            CrimeDatabase::class.java, DATABASE_NAME).addMigrations(migration_2_3).build()
    private val crimeDao = database.crimeDao()
    private val executor = Executors.newSingleThreadExecutor()
    private val filesDir = context.applicationContext.filesDir

    public fun getCrimes(): LiveData<List<Crime>> = crimeDao.getCrimes()

    public fun getCrime(id: UUID): LiveData<Crime?> = crimeDao.getCrime(id)

    public fun updateCrime(crime: Crime) {
        executor.execute { crimeDao.updateCrime(crime) }
    }

    public fun addCrime(crime: Crime) {
        executor.execute { crimeDao.addCrime(crime) }
    }

    public fun getPhotoFile(crime: Crime): File = File(filesDir, crime.photoFileName)

    companion object {
        private var INSTANCE: CrimeRepository? = null

        public fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }

        public fun get(): CrimeRepository {
            return INSTANCE ?: throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}