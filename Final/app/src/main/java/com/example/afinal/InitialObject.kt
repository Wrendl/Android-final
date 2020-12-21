package com.example.afinal

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class InitialObject(
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Int?
//    @SerializedName("articles")
//    val list: ArrayList<News>?
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
//        parcel.readArrayList() as ArrayList<News>?
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(status)
        if (totalResults != null) {
            parcel.writeInt(totalResults)
        }
//        parcel.writeArray(arrayOf(list))
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<InitialObject> {
        override fun createFromParcel(parcel: Parcel): InitialObject {
            return InitialObject(parcel)
        }

        override fun newArray(size: Int): Array<InitialObject?> {
            return arrayOfNulls(size)
        }
    }
}