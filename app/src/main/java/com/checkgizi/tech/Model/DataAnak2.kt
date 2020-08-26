package com.checkgizi.tech.Model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity
data class DataAnak2(
    @PrimaryKey @SerializedName("nama") val nama: String,
    @SerializedName("umur") val umur: String,
    @SerializedName("jk") val jk: String
):Parcelable