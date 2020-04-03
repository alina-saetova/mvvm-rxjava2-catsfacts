package ru.itis.cats_facts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_details.*
import ru.itis.cats_facts.data.model.CatItem
import ru.itis.cats_facts.data.model.LoadingStatus
import ru.itis.cats_facts.databinding.ActivityDetailsBinding
import ru.itis.cats_facts.di.Injectable
import ru.itis.cats_facts.view.adapter.CatFactAdapter
import ru.itis.cats_facts.viewmodel.DetailsViewModel
import javax.inject.Inject

class DetailsActivity : AppCompatActivity(), HasAndroidInjector,Injectable {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector() = dispatchingAndroidInjector

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_details)

        val adapter = CatFactAdapter(emptyList<CatItem>().toMutableList())
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(DetailsViewModel::class.java)
        observeViewModel()
        val categoryId = intent.extras?.getInt("id")
        categoryId?.let { viewModel.loadCatFacts(it) }
    }

    private fun observeViewModel() {
        viewModel.progress.observe(this, Observer { loadingState ->
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

        viewModel.items.observe(this, Observer { list ->
            (recyclerView.adapter as CatFactAdapter).update(list.toMutableList())
        })
    }
}
