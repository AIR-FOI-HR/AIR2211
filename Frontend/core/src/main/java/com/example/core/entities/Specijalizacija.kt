package com.example.core.entities

import com.google.gson.annotations.SerializedName
import java.sql.Date

/*
API:
{
    idSpecijalizacija: 3,
    specijalizant: 1,
    programSpecijalizacije: 1,
    glavniMentor: 1,
    odobrenaZa: "test",
    datumPocetka: "2022-01-01",
    datumZavrsetka: null,
    potpisMentora: null,
    zavrsnoMisljenje: null
}
 */

data class Specijalizacija(
    @SerializedName("idSpecijalizacija")
    var id_specijalizacija : Int? = null,

    @SerializedName("specijalizant")
    var specijalizantId : Int? = null,

    @SerializedName("programSpecijalizacije")
    var programSpecijalizacijeId : Int? = null,

    @SerializedName("glavniMentor")
    var glavniMentorId : Int? = null,

    @SerializedName("odobrenaZa")
    var odobrenaZa : String = "",

    @SerializedName("datumPocetka")
    var datumPocetka : String = "",

    @SerializedName("datumZavrsetka")
    var datumZavrsetka : String = "",

    @SerializedName("potpisMentora")
    var potpisMentora : String = "",

    @SerializedName("zavrsnoMisljenje")
    var zavrsnoMisljenje : String = "",
)
