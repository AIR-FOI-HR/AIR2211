package com.example.core.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StrucniRad(
    @SerializedName("idRad")
    var idRad : Int? = null,

    @SerializedName("specijalizacija")
    var specijalizacija : Int? = null,

    @SerializedName("naslovRad")
    var naslovRad : String = "",

    @SerializedName("objavljenU")
    var objavljenU : String?
) : Parcelable
