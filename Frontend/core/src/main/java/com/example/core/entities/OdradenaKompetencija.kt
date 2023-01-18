package com.example.core.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class OdradenaKompetencija(
    @SerializedName("specijalizacija")
    var specijalizacija : Int? = null,

    @SerializedName("kompetencija")
    var kompetencija : Int? = null,

    @SerializedName("stupanj")
    var stupanj : Int? = null,

    @SerializedName("datum")
    var datum : java.util.Date,

    @SerializedName("potpisMentora")
    var potpisMentora : java.lang.Byte?

) : Parcelable
