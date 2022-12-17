package com.example.interview1.ui.productDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.interview1.database.Product
import com.example.interview1.databinding.ActivityProductDetailBinding
import com.example.interview1.helper.ViewModelFactory
import com.example.interview1.ui.productList.ProductModel

class ProductDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "extra_user"
    }

    private lateinit var product: Product
    private lateinit var  productAddViewModel : ProductAddViewModel
    private lateinit var productDetailBinding: ActivityProductDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        productDetailBinding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(productDetailBinding.root)
        product=  Product()
        val user = intent.getParcelableExtra<ProductModel>(EXTRA_USER) as ProductModel
        productDetailBinding.username.text = user.productName
        productDetailBinding.vPrice.text = user.dimension
        productDetailBinding.vDimension.text = user.price
        productDetailBinding.vPriceUnit.text = user.unit


       productAddViewModel = obtainViewModel(this@ProductDetailActivity)
        productDetailBinding.btnCheckout.setOnClickListener {
            product.productName = productDetailBinding.username.text.toString()
            product.dimension = productDetailBinding.vPrice.text.toString()
            product.price = (productDetailBinding.vDimension.text as String).toInt()
            product.unit = "PCS"
            productAddViewModel.insert(product)
            Toast.makeText(
                this@ProductDetailActivity,
                "Sudah di tambahkan ke Checkout",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun obtainViewModel(activity: AppCompatActivity): ProductAddViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(ProductAddViewModel::class.java)
    }


}