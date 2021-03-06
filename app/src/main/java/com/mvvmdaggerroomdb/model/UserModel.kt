package com.mvvmdaggerroomdb.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mvvmdaggerroomdb.util.AppConstant

const val CURRENT_USER_ID = 0

@Entity(tableName = AppConstant.TABLE_USER)
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = CURRENT_USER_ID,
    var name: String? = null,
    var address: String? = null,
    var country: String? = null
) : Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(address)
        parcel.writeString(country)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserModel> {
        override fun createFromParcel(parcel: Parcel): UserModel {
            return UserModel(parcel)
        }

        override fun newArray(size: Int): Array<UserModel?> {
            return arrayOfNulls(size)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as UserModel

        return other.id == this.id
    }

}
