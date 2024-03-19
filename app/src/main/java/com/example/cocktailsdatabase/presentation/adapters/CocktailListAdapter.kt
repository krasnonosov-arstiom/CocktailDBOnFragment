package com.example.cocktailsdatabase.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cocktailsdatabase.databinding.ItemCocktailBinding
import com.example.cocktailsdatabase.domain.models.CocktailModel

class CocktailListAdapter : RecyclerView.Adapter<CocktailListAdapter.CocktailListHolder>() {

    private val dataSource = mutableListOf<CocktailModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailListHolder {
        val binding = ItemCocktailBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CocktailListHolder(binding)
    }

    override fun onBindViewHolder(holder: CocktailListHolder, position: Int) {
        val cocktail = dataSource[position]
        with(holder) {
            binding.title.text = cocktail.name
            binding.description.text = cocktail.category
            Glide.with(binding.image)
                .load(cocktail.imgUrl)
                .into(binding.image)
        }
    }

    override fun getItemCount(): Int = dataSource.size

    @SuppressLint("NotifyDataSetChanged")
    fun setDataSource(cocktails: List<CocktailModel>) {
        dataSource.clear()
        dataSource.addAll(cocktails)
        this.notifyDataSetChanged()
    }

    inner class CocktailListHolder(val binding: ItemCocktailBinding) :
        RecyclerView.ViewHolder(binding.root)
}