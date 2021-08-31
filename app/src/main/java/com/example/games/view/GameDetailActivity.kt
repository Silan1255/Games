package com.example.games.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.games.R
import com.example.games.model.GameDetail
import com.example.games.viewModel.GameDetailViewModel
import com.example.games.viewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_game_detail.*
import kotlinx.android.synthetic.main.item_games.view.*

class GameDetailActivity : AppCompatActivity() {
    lateinit var gameDetailViewModel: GameDetailViewModel

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_detail)

        gameDetailViewModel = ViewModelProviders.of(this).get(GameDetailViewModel::class.java)
        game_detail_progressBar.visibility = View.VISIBLE
        observeLiveData()
        intent.getStringExtra("oId")?.let {
            gameDetailViewModel.GetData(it)
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun observeLiveData() {
        gameDetailViewModel.games.observe(this, Observer {
            it?.let {
                it.forEach {
                    txt_game_name.text = it.oAdi
                    Glide.with(this).load(it.oResim).into(img_game)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        txt_game_explanation.setText(Html.fromHtml(it.oAciklama, Html.FROM_HTML_MODE_LEGACY))
                    }
                    else {
                        txt_game_explanation.setText(Html.fromHtml(it.oAciklama))
                    }
                    txt_game_explanation.setText(
                        Html.fromHtml(
                            it.oAciklama,
                            Html.FROM_HTML_MODE_COMPACT
                        )
                    )
                    txt_game_price.text = "fiyatı: " + it.oFiyat + "₺"
                }
            }
        })
        game_detail_progressBar.visibility = View.GONE
    }
}