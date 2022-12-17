package com.example.interview1.ui.checkout

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.interview1.database.Product
import com.example.interview1.database.repository.PenjualanRepository

class CheckoutViewModel(application: Application) : ViewModel() {

    private val mPenjualanRepository : PenjualanRepository = PenjualanRepository(application)
    fun getAllProduct() : LiveData<List<Product>> = mPenjualanRepository.getAllProduct()
}