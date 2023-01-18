package com.example.core.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DioSpecijalizacije(
    @SerializedName("idDioSpecijalizacije")
    var idDioSpecijalizacije : Int? = null,

    @SerializedName("programSpecijalizacije")
    var programSpecijalizacije : Int,

    @SerializedName("ustrojstvenaJedinica")
    var ustrojstvenaJedinica : Int

) : Parcelable
