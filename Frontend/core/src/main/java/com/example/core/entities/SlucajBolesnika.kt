package com.example.core.entities

import com.google.gson.annotations.SerializedName
import java.sql.Date

/*
API:
{
    idSlucaj: 1,
    specijalizacija: 3,
    datumSlucaj: "2022-01-02",
    dijagnozaSlucaj: "test",
    opisSlucaj: "test",
    potpisMentora: 1
}
*/
data class SlucajBolesnika(
    @SerializedName("idSlucaj")
    var idSlucaj : Int? = null,

    @SerializedName("specijalizacija")
    var specijalizacijaId : Int? = null,

    @SerializedName("datumSlucaj")
    var datumSlucaj : String = "",

    @SerializedName("dijagnozaSlucaj")
    var dijagnozaSlucaj : String = "",

    @SerializedName("opisSlucaj")
    var opisSlucaj : String = "",

    @SerializedName("potpisMentora")
    var potpisMentora : String = "",
)
