package myproject.kotlin.criminai_test_app_1

import androidx.room.TypeConverter
import java.util.*

public class CrimeTypeConverters {

    @TypeConverter
    public fun fromDate(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    public fun toDate(millisSinceEpoch: Long?): Date? {
        return millisSinceEpoch?.let { Date(it) }
    }

    @TypeConverter
    public fun toUUID(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }

    @TypeConverter
    public fun fromUUID(uuid: UUID?): String? {
        return uuid?.toString()
    }
}