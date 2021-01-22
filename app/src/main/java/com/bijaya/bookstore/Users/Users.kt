package com.bijaya1.weekfiveassignmentone.Users

import android.os.Parcel
import android.os.Parcelable

data class Users(
    val coventryId : Int? = null,
    val fname : String? = null,
    val lname : String? = null,
    val username : String? = null,
    val password : String? = null,
    val profile : String? = null,
    val batch : String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(coventryId)
        parcel.writeString(fname)
        parcel.writeString(lname)
        parcel.writeString(username)
        parcel.writeString(password)
        parcel.writeString(profile)
        parcel.writeString(batch)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Users> {
        override fun createFromParcel(parcel: Parcel): Users {
            return Users(parcel)
        }

        override fun newArray(size: Int): Array<Users?> {
            return arrayOfNulls(size)
        }
    }

}