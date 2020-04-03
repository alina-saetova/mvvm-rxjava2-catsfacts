package ru.itis.cats_facts.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.itis.cats_facts.R
import ru.itis.cats_facts.data.model.CatItem
import ru.itis.cats_facts.databinding.ItemCatfactBinding

class CatFactAdapter(
    private var list: MutableList<CatItem>
) : RecyclerView.Adapter<CatFactAdapter.CatFactViewHolder>(),
    BindableAdapter<MutableList<CatItem>> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatFactViewHolder =
        CatFactViewHolder.create(
            parent
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CatFactViewHolder, position: Int) {
        holder.binding.catFact = list[position]
        holder.binding.executePendingBindings()
    }

    override fun update(data: MutableList<CatItem>?) {
        if (data == null) return
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    class CatFactViewHolder(val binding: ItemCatfactBinding)
        : RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun create(parent: ViewGroup) =
                CatFactViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_catfact,
                        parent,
                        false
                    )
                )
        }
    }
}
