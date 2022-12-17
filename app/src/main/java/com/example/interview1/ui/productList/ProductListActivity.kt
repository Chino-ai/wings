package com.example.interview1.ui.productList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.interview1.R
import com.example.interview1.database.Product
import com.example.interview1.databinding.ActivityProductListBinding
import com.example.interview1.helper.ViewModelFactory
import com.example.interview1.ui.checkout.CheckoutActivity

class ProductListActivity : AppCompatActivity() {

    private lateinit var productListBinding: ActivityProductListBinding

    private lateinit var adapter: ListUserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productListBinding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(productListBinding.root)


        list.addAll(listUser)
        showRecycleView()

        productListBinding.btnCheckout.setOnClickListener {
            val intent = Intent(this@ProductListActivity, CheckoutActivity::class.java)
            startActivity(intent)
        }

    }



    private val listUser: ArrayList<ProductModel>
        get() {
            val dataProductName = resources.getStringArray(R.array.productName)
            val dataPrice = resources.getStringArray(R.array.price)
            val dataDimension = resources.getStringArray(R.array.dimension)
            val dataUnit = resources.getStringArray(R.array.unit)
            val listUser = ArrayList<ProductModel>()
            for (i in dataProductName.indices) {
                val user = ProductModel(
                   dataProductName[i],
                    dataPrice[i],
                    dataDimension[i],
                    dataUnit[i],
                )
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecycleView() {
        adapter = ListUserAdapter(list,this)
        productListBinding.rvGithub.layoutManager = LinearLayoutManager(this)
        productListBinding.rvGithub.setHasFixedSize(true)
        productListBinding.rvGithub.adapter = adapter


    }

    private var list: ArrayList<ProductModel> = arrayListOf()


}