package com.example.interview1.ui.checkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.interview1.R
import com.example.interview1.databinding.ActivityCheckoutBinding
import com.example.interview1.helper.ViewModelFactory

class CheckoutActivity : AppCompatActivity() {

    private lateinit var checkoutBinding: ActivityCheckoutBinding
    private lateinit var adapter: ListCheckoutAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkoutBinding = ActivityCheckoutBinding.inflate(layoutInflater)
        setContentView(checkoutBinding.root)
        val mainViewModel = obtainViewModel(this@CheckoutActivity)
        mainViewModel.getAllProduct().observe(this) {
            if (it != null) {
                adapter.setListNotes(it)
            }
        }

        adapter = ListCheckoutAdapter( )


        checkoutBinding.rvGithub.layoutManager = LinearLayoutManager(this)

        checkoutBinding.rvGithub.adapter = adapter
    }

    private fun obtainViewModel(activity: AppCompatActivity): CheckoutViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(CheckoutViewModel::class.java)
    }
}