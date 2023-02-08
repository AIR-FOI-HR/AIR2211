package com.example.core.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ispit(
    @SerializedName("idIspit")
    var idIspit : Int? = null,

    @SerializedName("specijalizacija")
    var specijalizacija : Int? = null,

    @SerializedName("datum")
    var datum : String,

    @SerializedName("vrijemeOdrzavanja")
    var vrijemeOdrzavanja : String,

    @SerializedName("nazivUstanove")
    var nazivUstanove : String,

    @SerializedName("prosao")
    var prosao : String?

) : Parcelable
