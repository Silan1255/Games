package com.example.games.servis

import com.example.games.model.GameDetail
import com.example.games.model.GameCategory
import com.example.games.model.Games
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GameApi {

    companion object {
        private const val Games = "gameType/{typeID}"
        private const val GameDetail = "gameDetail/{gameID}"
        private const val GameCategory = "gameType"
    }

    @GET(Games)
    fun getGames( @Path("typeID") typeID: String): Single<List<Games.GamesItem>>

    @GET(GameDetail)
    fun getGameDetail( @Path("gameID") gameID: String): Single<List<GameDetail.GameDetailItem>>

    @GET(GameCategory)
    fun getGameCategory(): Single<List<GameCategory.GameCategoryItem>>

}