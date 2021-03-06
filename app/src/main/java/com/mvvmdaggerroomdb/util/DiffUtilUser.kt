package com.mvvmdaggerroomdb.util

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.mvvmdaggerroomdb.model.UserModel


class DiffUtilUser(var newList: ArrayList<UserModel>, var oldList: ArrayList<UserModel>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].equals(newList[newItemPosition])
    }

    @Nullable
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {

        val bundle = Bundle()
        if (!oldList[oldItemPosition].equals(newList[newItemPosition])) {
            bundle.putParcelable(AppConstant.KEY_MODEL, newList[newItemPosition])
        }

        //you can return particular field for changed item.
        return if (bundle.size() == 0) null else bundle
    }
}