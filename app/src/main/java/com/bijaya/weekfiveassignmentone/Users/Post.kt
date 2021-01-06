package com.bijaya1.weekfiveassignmentone.Users

import android.os.Parcel
import android.os.Parcelable

data class Post(
    val user:String?=null,
    val profile:String?=null,
    val status:String?=null,
    val link:String?=null
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(user)
        parcel.writeString(profile)
        parcel.writeString(status)
        parcel.writeString(link)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Post> {
        override fun createFromParcel(parcel: Parcel): Post {
            return Post(parcel)
        }

        override fun newArray(size: Int): Array<Post?> {
            return arrayOfNulls(size)
        }
    }

}