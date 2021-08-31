package com.example.games.viewModel

import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.games.model.GameCategory
import com.example.games.model.Games
import com.example.games.servis.GameApiServis
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel : ViewModel() {
    private val dispoosable = CompositeDisposable()
    private val gameAPIServis = GameApiServis()
    fun refreshData() {
        GetData("1")
    }

    fun getCategory() {
        GetCategoryData()
    }

    val games = MutableLiveData<List<Games.GamesItem>>()
    val gamesCategory = MutableLiveData<List<GameCategory.GameCategoryItem>>()

    private fun GetData(typeID: String) {
        dispoosable.add(
            gameAPIServis.getGame(typeID)
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Games.GamesItem>>() {
                    override fun onSuccess(t: List<Games.GamesItem>) {
                        games.value = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }

    fun GetGamesData(typeID: String) {
        dispoosable.add(
            gameAPIServis.getGame(typeID)
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Games.GamesItem>>() {
                    override fun onSuccess(t: List<Games.GamesItem>) {
                        games.value = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }

    private fun GetCategoryData() {
        dispoosable.add(
            gameAPIServis.getCaterory()
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableSingleObserver<List<GameCategory.GameCategoryItem>>() {
                    override fun onSuccess(t: List<GameCategory.GameCategoryItem>) {
                        gamesCategory.value = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }
}