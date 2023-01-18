package com.example.core.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class OdradeniDioSpecijalizacije(
    @SerializedName("specijalizacija")
    var specijalizacija : Int? = null,

    @SerializedName("dioSpecijalizacije")
    var dioSpecijalizacije : Int? = null,

    @SerializedName("mentor")
    var mentor : Int,

    @SerializedName("mentorPotpis")
    var mentorPotpis : java.lang.Byte?,

    @SerializedName("glavniMentorPotpis")
    var glavniMentorPotpis : java.lang.Byte?,

    @SerializedName("trajeOd")
    var trajeOd : java.util.Date,

    @SerializedName("trajeDo")
    var trajeDo : java.util.Date?

) : Parcelable
