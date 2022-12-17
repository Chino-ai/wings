package com.example.interview1.ui.productDetail

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.interview1.database.Product
import com.example.interview1.database.repository.PenjualanRepository

class ProductAddViewModel(application: Application): ViewModel() {
    private val mPenjualanRepository: PenjualanRepository = PenjualanRepository(application)

    fun insert(product: Product){
        mPenjualanRepository.insert(product)
    }
}