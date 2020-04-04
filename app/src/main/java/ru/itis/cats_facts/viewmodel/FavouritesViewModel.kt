package ru.itis.cats_facts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.itis.cats_facts.data.model.CatItem
import ru.itis.cats_facts.data.model.LoadingStatus
import ru.itis.cats_facts.data.repository.CatFactRepository
import javax.inject.Inject

class FavouritesViewModel @Inject constructor(val repository: CatFactRepository) : ViewModel() {

    private val disposables = CompositeDisposable()

    private var _items = MutableLiveData<List<CatItem>>()
    val items: LiveData<List<CatItem>>
        get() = _items

    private var _progress = MutableLiveData<LoadingStatus>()
    val progress: LiveData<LoadingStatus>
        get() = _progress

    init {
        loadFavourites()
    }

    fun loadFavourites() {
        _progress.value = LoadingStatus.RUNNING
        disposables.add(repository.getFavourites()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _items.value = it
                _progress.value = LoadingStatus.SUCCESS
            }, {
                _progress.value = LoadingStatus.FAILED
            })
        )
    }

    fun delete(catItem: CatItem) {
        disposables.add(repository.deleteFavourite(catItem)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {

            })
    }
}
