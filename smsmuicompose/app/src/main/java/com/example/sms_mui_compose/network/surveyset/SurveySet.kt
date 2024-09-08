package com.example.sms_mui_compose.network.surveyset

import android.os.Parcel
import android.os.Parcelable

class SurveySet() :Parcelable {
    var surveySetId:Int = 0
    var description:String = ""
    var name:String = ""
    var creationDate:String= ""
    var groupId:Int = 0
    var groupName:String= ""

    constructor(parcel: Parcel) : this() {
        surveySetId = parcel.readInt()
        description = parcel.readString().toString()
        name = parcel.readString().toString()
        creationDate = parcel.readString().toString()
        groupId = parcel.readInt()
        groupName = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(surveySetId)
        parcel.writeString(description)
        parcel.writeString(name)
        parcel.writeString(creationDate)
        parcel.writeInt(groupId)
        parcel.writeString(groupName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SurveySet> {
        override fun createFromParcel(parcel: Parcel): SurveySet {
            return SurveySet(parcel)
        }

        override fun newArray(size: Int): Array<SurveySet?> {
            return arrayOfNulls(size)
        }
    }
}
