package com.example.games.model


import com.google.gson.annotations.SerializedName

class Games : ArrayList<Games.GamesItem>(){
    data class GamesItem(
        @SerializedName("o_adi")
        var oAdi: String,
        @SerializedName("o_fiyat")
        var oFiyat: String,
        @SerializedName("o_resim")
        var oResim: String,
        @SerializedName("o_id")
        var oId: String
    )
}