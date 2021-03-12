package com.mvvmdaggerroomdb.model

import android.os.Parcel
import android.os.Parcelable

data class CountryResponseModel(
    val code: String?,
    val result: List<CountryModel>?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.createTypedArrayList(CountryModel)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(code)
        parcel.writeTypedList(result)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CountryResponseModel> {
        override fun createFromParcel(parcel: Parcel): CountryResponseModel {
            return CountryResponseModel(parcel)
        }

        override fun newArray(size: Int): Array<CountryResponseModel?> {
            return arrayOfNulls(size)
        }
    }
}
