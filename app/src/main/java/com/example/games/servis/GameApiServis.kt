package com.example.games.servis

import com.example.games.model.GameDetail
import com.example.games.model.GameCategory
import com.example.games.model.Games
import com.google.gson.GsonBuilder
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path

class GameApiServis {

    private val BASE_URL = "http://oyunpuanla.com/game/public/index.php/"
    var gson = GsonBuilder()
        .setLenient()
        .create()
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(GameApi::class.java)


    fun getGame( typeID : String): Single<List<Games.GamesItem>> {
        return api.getGames(typeID)
    }

    fun getGameDetail(gameDetail: String): Single<List<GameDetail.GameDetailItem>> {
        return api.getGameDetail(gameDetail)
    }

    fun getCaterory(): Single<List<GameCategory.GameCategoryItem>> {
        return api.getGameCategory()
    }
}