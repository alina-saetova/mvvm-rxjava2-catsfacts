package ru.itis.cats_facts.view.adapter

import ru.itis.cats_facts.data.model.CatItem

interface CatItemDeleteListener {

    fun delete(catItem: CatItem)
}
