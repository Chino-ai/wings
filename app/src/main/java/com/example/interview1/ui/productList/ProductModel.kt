package com.example.interview1.ui.productList

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductModel(

    var productName: String,
    var price: String,
    var dimension: String,
    var unit: String,

): Parcelable










