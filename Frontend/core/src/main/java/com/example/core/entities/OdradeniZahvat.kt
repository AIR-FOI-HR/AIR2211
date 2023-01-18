package com.example.core.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class OdradeniZahvat(
    @SerializedName("specijalizacija")
    var specijalizacija : Int? = null,

    @SerializedName("zahvat")
    var zahvat : Int? = null,

    @SerializedName("stupanj")
    var stupanj : Int? = null,

    @SerializedName("datum")
    var datum : java.util.Date,

    @SerializedName("potpisMentora")
    var potpisMentora : java.lang.Byte?

) : Parcelable
