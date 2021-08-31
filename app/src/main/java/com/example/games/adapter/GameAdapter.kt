package com.example.games.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.games.R
import com.example.games.model.Games
import kotlinx.android.synthetic.main.item_games.view.*

class GameAdapter(val GamesList: ArrayList<Games.GamesItem>) :
    RecyclerView.Adapter<GameAdapter.GamesViewHolder>() {

    var gamesClickListener: (String) -> Unit = { _ -> }
    class GamesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_games, parent, false)
        return GamesViewHolder(view)
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.itemView.games_name.text = GamesList.get(position).oAdi
        holder.itemView.games_price.text= "Fiyatı: "+GamesList.get(position).oFiyat+ "₺"
        Glide.with(holder.itemView.context).load(GamesList.get(position).oResim).into(holder.itemView.img_games)
        holder.itemView.setOnClickListener {
            gamesClickListener(GamesList.get(position).oId)
        }
    }

    override fun getItemCount(): Int = GamesList.size

    fun GamesUpdate(newGameList: List<Games.GamesItem>) {
        GamesList.clear()
        GamesList.addAll(newGameList)
        notifyDataSetChanged()
    }
}

