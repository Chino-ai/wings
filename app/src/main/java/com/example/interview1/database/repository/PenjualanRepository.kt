package com.example.interview1.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.interview1.database.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class PenjualanRepository(application: Application) {
    private val mProductDatabaseDao : ProductDatabaseDao

    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = JualRoomDatabase.getDatabase(application)
        mProductDatabaseDao = db.productDatabaseDao()


    }

    fun insert(product: Product){
        executorService.execute{mProductDatabaseDao.insert(product)}
    }
    fun getAllProduct(): LiveData<List<Product>> = mProductDatabaseDao.getAllProduct()


}