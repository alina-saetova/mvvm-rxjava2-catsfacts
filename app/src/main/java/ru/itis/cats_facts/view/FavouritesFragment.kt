package ru.itis.cats_facts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ru.itis.cats_facts.R
import ru.itis.cats_facts.databinding.FragmentFavouritesBinding
import ru.itis.cats_facts.di.Injectable
import ru.itis.cats_facts.viewmodel.FavouritesViewModel
import javax.inject.Inject

class FavouritesFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: FavouritesViewModel
    lateinit var binding: FragmentFavouritesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouritesBinding.inflate(inflater)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(FavouritesViewModel::class.java)
        binding.viewModel = viewModel
        return binding.root
    }

}
