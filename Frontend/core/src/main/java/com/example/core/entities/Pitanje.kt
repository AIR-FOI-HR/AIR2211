package com.example.core.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pitanje(
    @SerializedName("idPitanje")
    var idPitanje : Int? = null,

    @SerializedName("provjera")
    var provjera : Int? = null,

    @SerializedName("sadrzajPitanja")
    var sadrzajPitanja : String

) : Parcelable
