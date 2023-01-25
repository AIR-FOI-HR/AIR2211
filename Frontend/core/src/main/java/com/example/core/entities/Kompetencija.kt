package com.example.core.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Kompetencija(
    @SerializedName("idKompetencija")
    var idKompetencija : Int? = null,

    @SerializedName("programSpecijalizacije")
    var programSpecijalizacije : Int? = null,

    @SerializedName("nazivKompetencija")
    var nazivKompetencija : String?,

    @SerializedName("posebna")
    var posebna : String?
) : Parcelable
