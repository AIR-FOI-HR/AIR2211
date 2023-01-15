package com.example.core.entities

import com.google.gson.annotations.SerializedName

data class StrucniRad(
    @SerializedName("idRad")
    var idRad : Int? = null,

    @SerializedName("specijalizacija")
    var specijalizacija : Int? = null,

    @SerializedName("naslovRad")
    var naslovRad : String = "",

    @SerializedName("objavljenU")
    var objavljenU : String = ""
)
