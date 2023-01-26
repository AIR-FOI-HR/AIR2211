package com.example.core.entities

import com.google.gson.annotations.SerializedName

data class Prijava(
    @SerializedName("email")
    var email : String?,

    @SerializedName("lozinka")
    var lozinka : String?,
)
