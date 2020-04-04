package ru.itis.cats_facts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_details.*
import ru.itis.cats_facts.R
import ru.itis.cats_facts.data.model.CatItem
import ru.itis.cats_facts.data.model.LoadingStatus
import ru.itis.cats_facts.databinding.FragmentFavouritesBinding
import ru.itis.cats_facts.di.Injectable
import ru.itis.cats_facts.view.adapter.CatFactAdapter
import ru.itis.cats_facts.view.adapter.CatItemDeleteListener
import ru.itis.cats_facts.view.adapter.FavouriteAdapter
import ru.itis.cats_facts.viewmodel.FavouritesViewModel
import javax.inject.Inject

class FavouritesFragment : Fragment(), CatItemDeleteListener, Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: FavouritesViewModel
    lateinit var binding: FragmentFavouritesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouritesBinding.inflate(inflater)
        val adapter = FavouriteAdapter(emptyList<CatItem>().toMutableList(), this)
        binding.recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(FavouritesViewModel::class.java)
        observeViewModel()
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    private fun observeViewModel() {
        viewModel.progress.observe(viewLifecycleOwner, Observer { loadingState ->
            loadingState?.let {
                progressBar.visibility = when(it) {
                    LoadingStatus.RUNNING -> View.VISIBLE
                    LoadingStatus.SUCCESS -> View.GONE
                    LoadingStatus.FAILED -> View.GONE
                }
                iv_error.visibility = when(it) {
                    LoadingStatus.RUNNING -> View.GONE
                    LoadingStatus.SUCCESS -> View.GONE
                    LoadingStatus.FAILED -> View.VISIBLE
                }
            }
        })

        viewModel.items.observe(viewLifecycleOwner, Observer { list ->
            (recyclerView.adapter as FavouriteAdapter).update(list.toMutableList())
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadFavourites()
    }

    override fun delete(catItem: CatItem) {
        viewModel.delete(catItem)
    }

}
