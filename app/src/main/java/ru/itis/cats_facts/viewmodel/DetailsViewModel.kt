package ru.itis.cats_facts.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.util.NotificationLite.disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import ru.itis.cats_facts.data.model.CatItem
import ru.itis.cats_facts.data.model.LoadingStatus
import ru.itis.cats_facts.data.repository.CatFactRepository
import javax.inject.Inject


class DetailsViewModel @Inject constructor(val repository: CatFactRepository): ViewModel() {

    private val disposables = CompositeDisposable()

    private var _items = MutableLiveData<List<CatItem>>()
    val items: LiveData<List<CatItem>>
        get() = _items

    private var _progress = MutableLiveData<LoadingStatus>()
    val progress: LiveData<LoadingStatus>
        get() = _progress

    fun loadCatFacts(categoryId: Int) {
        _progress.value = LoadingStatus.RUNNING
        disposables.add(repository.getCatFacts(categoryId)
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

    override fun onCleared() {
        super.onCleared()
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }
}
