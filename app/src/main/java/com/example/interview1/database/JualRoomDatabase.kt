package com.example.interview1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.interview1.R
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.concurrent.Executors

@Database(entities = [Product::class],
    version =15,
     exportSchema = false)
abstract class JualRoomDatabase : RoomDatabase() {
    abstract fun productDatabaseDao(): ProductDatabaseDao


    companion object {
        @Volatile
        private var INSTANCE: JualRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): JualRoomDatabase {
            if (INSTANCE == null) {
                synchronized(JualRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        JualRoomDatabase::class.java, "products"
                    ).fallbackToDestructiveMigration().build()
                }
            }
            return INSTANCE as JualRoomDatabase

        }


    }

}



