package com.example.interview1.ui.productList

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.interview1.database.Product
import com.example.interview1.databinding.ItemPenjualanBinding
import com.example.interview1.helper.NoteDiffCallback
import com.example.interview1.helper.ViewModelFactory
import com.example.interview1.ui.checkout.CheckoutActivity
import com.example.interview1.ui.productDetail.ProductAddViewModel
import com.example.interview1.ui.productDetail.ProductDetailActivity



class ListUserAdapter(val listUser: ArrayList<ProductModel>,private val appCompatActivity: AppCompatActivity) :
    RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    private lateinit var  productAddViewModel : ProductAddViewModel
    private lateinit var product: Product
    inner class ListViewHolder(private var binding: ItemPenjualanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listUser: ProductModel) {
            with(binding) {
                tvProduct.text = listUser.productName
                tvHarga.text = listUser.price
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, ProductDetailActivity::class.java)
                    intent.putExtra(ProductDetailActivity.EXTRA_USER, listUser)
                    itemView.context.startActivity(intent)
                }

                tvDetail.setOnClickListener {
                    product = Product()
                    productAddViewModel = obtainViewModel(appCompatActivity)
                    product.productName = tvProduct.text.toString()
                    product.dimension = "13 cm x 10 cm"
                    product.price = (tvHarga.text as String).toInt()
                    product.unit = "PCS"
                    productAddViewModel.insert(product)
                    Toast.makeText(
                        appCompatActivity,
                        "Sudah di tambahkan ke Checkout",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemRowUserBinding =
            ItemPenjualanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemRowUserBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])

    }
    private fun obtainViewModel(activity: AppCompatActivity): ProductAddViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(ProductAddViewModel::class.java)
    }

    override fun getItemCount(): Int = listUser.size

}