package com.example.core.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SlucajBolesnika(
    @SerializedName("idSlucaj")
    var idSlucaj : Int? = null,

    @SerializedName("specijalizacija")
    var specijalizacijaId : Int? = null,

    @SerializedName("datumSlucaj")
    var datumSlucaj : String?,

    @SerializedName("dijagnozaSlucaj")
    var dijagnozaSlucaj : String?,

    @SerializedName("opisSlucaj")
    var opisSlucaj : String?,

    @SerializedName("potpisMentora")
    var potpisMentora : java.lang.Byte?
) : Parcelable
