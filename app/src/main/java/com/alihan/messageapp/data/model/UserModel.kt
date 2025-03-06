package com.alihan.messageapp.data.model

import android.provider.ContactsContract.CommonDataKinds.Email

data class UserModel(
    var uuid:String="",
    var email: String?=null
)
