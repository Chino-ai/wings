package com.example.interview1.ui.checkout

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.interview1.database.Product
import com.example.interview1.databinding.ItemPenjualanBinding
import com.example.interview1.databinding.ItemPenjualanCheckoutBinding
import com.example.interview1.helper.NoteDiffCallback
import com.example.interview1.ui.productDetail.ProductDetailActivity



class ListCheckoutAdapter :
    RecyclerView.Adapter<ListCheckoutAdapter.ListViewHolder>() {
    private val listUsers = ArrayList<Product>()
    fun setListNotes(listUsers: List<Product>) {
        val diffCallback = NoteDiffCallback(this.listUsers, listUsers)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listUsers.clear()
        this.listUsers.addAll(listUsers)
        diffResult.dispatchUpdatesTo(this)
    }


    inner class ListViewHolder(private var binding: ItemPenjualanCheckoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listUser: Product) {
            with(binding) {
                tvProduct.text = listUser.productName
                tvHarga.text = listUser.price.toString()
                tvPcs.text = listUser.unit
                /*itemView.setOnClickListener {
                    val intent = Intent(itemView.context, ProductDetailActivity::class.java)
                    intent.putExtra(ProductDetailActivity.EXTRA_USER, listUser)
                    itemView.context.startActivity(intent)
                }

                tvDetail.setOnClickListener {
                    val intent = Intent(itemView.context, CheckoutActivity::class.java)
                    itemView.context.startActivity(intent)
                }*/


            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemRowUserBinding =
            ItemPenjualanCheckoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemRowUserBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUsers[position])

    }

    override fun getItemCount(): Int = listUsers.size

}