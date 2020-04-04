package ru.itis.cats_facts.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import ru.itis.cats_facts.DetailsActivity
import ru.itis.cats_facts.databinding.FragmentCategoriesBinding
import ru.itis.cats_facts.di.Injectable

class CategoriesFragment : Fragment(), Injectable {

    lateinit var binding: FragmentCategoriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesBinding.inflate(inflater)

        setButtons()
        return binding.root
    }

    private val clickListener: View.OnClickListener = View.OnClickListener { view ->
        var id = 1
        when ((view as Button).text) {
            "boxes" -> id = 5
            "clothes" -> id = 15
            "hats" -> id = 1
            "sinks" -> id = 14
            "space" -> id = 2
            "sunglasses" -> id = 4
            "ties" -> id = 7
        }
        val intent = Intent(activity, DetailsActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

    private fun setButtons() {
        binding.btnBoxes.setOnClickListener(clickListener)
        binding.btnClothes.setOnClickListener(clickListener)
        binding.btnHats.setOnClickListener(clickListener)
        binding.btnSinks.setOnClickListener(clickListener)
        binding.btnSpace.setOnClickListener(clickListener)
        binding.btnSunglasses.setOnClickListener(clickListener)
        binding.btnTies.setOnClickListener(clickListener)
    }
}
