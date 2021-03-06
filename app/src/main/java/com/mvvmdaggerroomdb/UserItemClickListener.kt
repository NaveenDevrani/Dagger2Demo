package com.mvvmdaggerroomdb

import com.mvvmdaggerroomdb.model.UserModel

interface UserItemClickListener {
    fun onClickItem(user: UserModel)
    fun onDelete(user: UserModel, position: Int)
    fun onEdit(user: UserModel, position: Int)
}