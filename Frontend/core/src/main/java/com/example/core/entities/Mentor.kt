package com.example.core.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mentor(
    @SerializedName("idMentor")
    var idMentor : Int? = null,

    @SerializedName("ime")
    var ime : String,

    @SerializedName("prezime")
    var prezime : String,

    @SerializedName("ustrojstvenaJedinica")
    var ustrojstvenaJedinica : Int
) : Parcelable
