package com.example.core.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DnevnaAktivnost(
    @SerializedName("idAktivnost")
    var idAktivnost : Int? = null,

    @SerializedName("specijalizacija")
    var specijalizacijaId : Int? = null,

    @SerializedName("datumAktivnost")
    var datumAktivnost : java.util.Date,

    @SerializedName("nazivAktivnost")
    var nazivAktivnost : String = "",

    @SerializedName("opisAktivnost")
    var opisAktivnost : String?,

    @SerializedName("brZahvataNadzor")
    var brZahvataNadzor : Int?,

    @SerializedName("brZahvataSamostalno")
    var brZahvataSamostalno : Int?,

    @SerializedName("potpisMentora")
    var potpisMentora : java.lang.Byte?
) : Parcelable
