package ru.itis.cats_facts.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.itis.cats_facts.R
import ru.itis.cats_facts.data.model.CatItem
import ru.itis.cats_facts.databinding.ItemCatfactBinding
import ru.itis.cats_facts.databinding.ItemFavouriteBinding

class FavouriteAdapter(
    private var list: MutableList<CatItem>,
    private var clickListener: CatItemDeleteListener
) : RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder>(),
    BindableAdapter<MutableList<CatItem>> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):FavouriteViewHolder =
        FavouriteViewHolder.create(
            parent
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        holder.binding.catFact = list[position]
        holder.binding.ibDelete.setOnClickListener {
            clickListener.delete(list[position])
            delete(position)
        }
        holder.binding.executePendingBindings()
    }

    override fun update(data: MutableList<CatItem>?) {
        if (data == null) return
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    private fun delete(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, list.size)
    }

    class FavouriteViewHolder(val binding: ItemFavouriteBinding)
        : RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun create(parent: ViewGroup) =
                FavouriteViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_favourite,
                        parent,
                        false
                    )
                )
        }
    }
}
