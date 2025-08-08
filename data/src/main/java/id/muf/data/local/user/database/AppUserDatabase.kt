package id.muf.data.local.user.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.muf.data.local.user.dao.UserDao
import id.muf.data.local.user.entity.DetailUserEntity
import id.muf.data.local.user.entity.ListUserEntity

@Database(
    entities = [ListUserEntity::class, DetailUserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppUserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppUserDatabase? = null

        fun getDatabase(context: Context): AppUserDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppUserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}