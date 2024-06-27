package com.example.societymanagementsystem.admin

import android.os.Parcel
import android.os.Parcelable

data class GloceryModel(
    val name: String,
    val number: String,
    val address: String,
    val hours: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(number)
        parcel.writeString(address)
        parcel.writeString(hours)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GloceryModel> {
        override fun createFromParcel(parcel: Parcel): GloceryModel {
            return GloceryModel(parcel)
        }

        override fun newArray(size: Int): Array<GloceryModel?> {
            return arrayOfNulls(size)
        }
    }
}