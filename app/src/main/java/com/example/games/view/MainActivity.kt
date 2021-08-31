package com.example.games.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.games.R
import com.example.games.adapter.GameAdapter
import com.example.games.viewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_game_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private val gameAdapter = GameAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.refreshData()
        mainActivityViewModel.getCategory()
        game_progressBar.visibility = View.VISIBLE

        rcy_games.layoutManager = GridLayoutManager(this, 2)
        rcy_games.adapter = gameAdapter

        observeLiveData()
        gameAdapter.gamesClickListener = { oId ->
            var intent = Intent(this, GameDetailActivity::class.java)
            intent.putExtra("oId", oId)
            startActivity(intent)
        }
    }
    fun observeLiveData() {
        mainActivityViewModel.games.observe(this, Observer {
            it.let {
                gameAdapter.GamesUpdate(it)
            }
        })
        game_progressBar.visibility = View.GONE
        mainActivityViewModel.gamesCategory.observe(this, Observer {
            it.let { category ->
                tabLayout.removeAllTabs()
                category.forEach {
                    tabLayout.addTab(tabLayout.newTab().setText(it.turAd), false)
                }
            }
        })
        game_progressBar.visibility = View.GONE
    }
}