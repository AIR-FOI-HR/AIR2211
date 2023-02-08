package com.example.core.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Zahvat(
    @SerializedName("idZahvat")
    var idZahvat : Int? = null,

    @SerializedName("programSpecijalizacije")
    var programSpecijalizacije : Int,

    @SerializedName("nazivZahvat")
    var nazivZahvat : String
) : Parcelable{
    override fun toString(): String {
        return "${idZahvat} - ${nazivZahvat}"
    }
}
