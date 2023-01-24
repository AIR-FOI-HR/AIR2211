package com.example.core.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class ProvjeraZnanja(
    @SerializedName("idProvjera")
    var idProvjera : Int? = null,

    @SerializedName("specijalizacija")
    var specijalizacija : Int? = null,

    @SerializedName("datumProvjera")
    var datumProvjera : String,

    @SerializedName("ocjenaProvjera")
    var ocjenaProvjera : Int?,

    @SerializedName("potpisMentora")
    var potpisMentora : java.lang.Byte?
) : Parcelable
