package com.example.interview1.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
@Entity(tableName = "product")
@Parcelize
data class Product(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,



    @ColumnInfo(name = "productName")
    var productName: String? = null,


    @ColumnInfo(name = "price")
    var price: Int? = null,
    @ColumnInfo(name = "dimension")
    var dimension: String? = null,


    @ColumnInfo(name = "unit")
    var unit: String? = null,

): Parcelable










