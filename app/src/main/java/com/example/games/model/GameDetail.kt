package com.example.games.model


import com.google.gson.annotations.SerializedName

class GameDetail : ArrayList<GameDetail.GameDetailItem>(){
    data class GameDetailItem(
        @SerializedName("o_aciklama")
        var oAciklama: String,
        @SerializedName("o_adi")
        var oAdi: String,
        @SerializedName("o_appid")
        var oAppid: String,
        @SerializedName("o_arkaplanfoto")
        var oArkaplanfoto: String,
        @SerializedName("o_cikis_trh")
        var oCikisTrh: String,
        @SerializedName("o_fiyat")
        var oFiyat: String,
        @SerializedName("o_lsistemgereksinim")
        var oLsistemgereksinim: String,
        @SerializedName("o_msistemgereksinim")
        var oMsistemgereksinim: String,
        @SerializedName("o_oyunpuani")
        var oOyunpuani: Any,
        @SerializedName("o_resim")
        var oResim: String,
        @SerializedName("o_wsistemgereksinim")
        var oWsistemgereksinim: String,
        @SerializedName("o_id")
        var oİd: String
    )
}