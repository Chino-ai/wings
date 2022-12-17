package com.example.interview1.helper

import androidx.recyclerview.widget.DiffUtil
import com.example.interview1.database.Product


class NoteDiffCallback(
    private val mOldUserList: List<Product>,
    private val mNewUserList: List<Product>
): DiffUtil.Callback(){

    override fun getOldListSize(): Int {
        return mOldUserList.size
    }

    override fun getNewListSize(): Int {
        return mNewUserList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldUserList[oldItemPosition].id == mNewUserList[newItemPosition].id

    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee = mOldUserList[oldItemPosition]
        val newEmployee = mNewUserList[newItemPosition]
        return oldEmployee.productName == newEmployee.productName && oldEmployee.productName== newEmployee.productName
    }
}