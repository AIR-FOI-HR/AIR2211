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
    var mentorPotpis : String?,

    @SerializedName("glavniMentorPotpis")
    var glavniMentorPotpis : String?,

    @SerializedName("trajeOd")
    var trajeOd : String?,

    @SerializedName("trajeDo")
    var trajeDo : String?

) : Parcelable
