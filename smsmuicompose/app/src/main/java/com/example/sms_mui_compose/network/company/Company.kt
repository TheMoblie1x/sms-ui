package com.example.sms_mui_compose.network.company

import android.os.Parcel
import android.os.Parcelable

public class Company() : Parcelable {
    lateinit var companyId:String
    lateinit var contactInfo:String
    lateinit var name:String
    lateinit var location:String
    lateinit var email:String
    lateinit var address:String

    constructor(parcel: Parcel) : this() {
        companyId = parcel.readString().toString()
        contactInfo = parcel.readString().toString()
        name = parcel.readString().toString()
        location = parcel.readString().toString()
        email = parcel.readString().toString()
        address = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(companyId)
        parcel.writeString(contactInfo)
        parcel.writeString(name)
        parcel.writeString(location)
        parcel.writeString(email)
        parcel.writeString(address)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Company> {
        override fun createFromParcel(parcel: Parcel): Company {
            return Company(parcel)
        }

        override fun newArray(size: Int): Array<Company?> {
            return arrayOfNulls(size)
        }
    }

}
