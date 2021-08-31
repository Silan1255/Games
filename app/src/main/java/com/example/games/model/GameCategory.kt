package com.example.games.model


import com.google.gson.annotations.SerializedName

class GameCategory : ArrayList<GameCategory.GameCategoryItem>(){
    data class GameCategoryItem(

        @SerializedName("tur_ad")
        var turAd: String,

        @SerializedName("tur_id")
        var turİd: String
    )
}