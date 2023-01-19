package com.example.core.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/*
API:
{
    "id_specijalizant": 1,
    "ime": "Mate",
    "prezime": "Matic",
    "email": "mmatic@gmail.com",
    "lozinka": "pass1",
    "slika": "slika"
}
*/

@Parcelize
data class Specijalizant (
    @SerializedName("idSpecijalizant")
    var id_specijalizant : Int? = null,

    @SerializedName("ime")
    var ime : String = "",

    @SerializedName("prezime")
    var prezime : String = "",

    @SerializedName("email")
    var email : String = "",

    @SerializedName("lozinka")
    var lozinka : String = "",

    @SerializedName("slika")
    var slika : String = "",
) : Parcelable