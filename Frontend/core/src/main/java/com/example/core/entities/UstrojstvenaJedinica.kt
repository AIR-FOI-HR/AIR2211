package com.example.core.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UstrojstvenaJedinica(
    @SerializedName("idJedinica")
    var idJedinica : Int? = null,

    @SerializedName("nazivUstanova")
    var nazivUstanova : String?,

    @SerializedName("nazivJedinica")
    var nazivJedinica : String?

) : Parcelable
