package ru.itis.cats_facts.viewmodel

import android.widget.Button
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class CategoriesViewModel @Inject constructor() : ViewModel() {

    fun click(view: Button) {
        val ctg = view.text
        var id = 1
        when (ctg) {
            "boxes" -> id = 5
            "clothes" -> id = 15
            "hats" -> id = 1
            "sinks" -> id = 14
            "space" -> id = 2
            "sunglasses" -> id = 4
            "ties" -> id = 7
        }
    }

}
