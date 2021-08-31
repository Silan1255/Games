package com.example.games.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.games.model.GameDetail
import com.example.games.model.Games
import com.example.games.servis.GameApiServis
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class GameDetailViewModel : ViewModel() {
    private val dispoosable = CompositeDisposable()
    private val gameAPIServis = GameApiServis()

    val games = MutableLiveData<List<GameDetail.GameDetailItem>>()

     fun GetData(gameID: String) {
        dispoosable.add(
            gameAPIServis.getGameDetail(gameID)
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<GameDetail.GameDetailItem>>() {
                    override fun onSuccess(t: List<GameDetail.GameDetailItem>) {
                        games.value = t
                    }
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }
}