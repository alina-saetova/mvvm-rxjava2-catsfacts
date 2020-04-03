package ru.itis.cats_facts.view

import android.widget.ImageButton
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.itis.cats_facts.R
import ru.itis.cats_facts.view.adapter.BindableAdapter


@BindingAdapter("recycler")
fun <T> setSubsRecyclerViewProperties(recyclerView: RecyclerView, data: T) {
    if (recyclerView.adapter is BindableAdapter<*>) {
        (recyclerView.adapter as BindableAdapter<T>).update(data)
    }
}

@BindingAdapter("image")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view)
        .load(url)
        .placeholder(R.drawable.image_placeholder)
        .error(R.drawable.image_error)
        .into(view)
}

//@BindingAdapter(value = ["setupVisibility"])
//fun ProgressBar.progressVisibility(loadingStatus: LoadingStatus?) {
//    Log.e("VISI", "vsisiisisis")
//    loadingStatus?.let {
//        isVisible = when(it) {
//            LoadingStatus.RUNNING -> true
//            LoadingStatus.SUCCESS -> false
//            LoadingStatus.FAILED -> false
//        }
//    }
//}
//
//@BindingAdapter("errorPic")
//fun setErrorPicture(view: ImageView, loadingStatus: LoadingStatus?) {
//    when(loadingStatus) {
//        LoadingStatus.RUNNING -> view.visibility = View.INVISIBLE
//        LoadingStatus.SUCCESS -> view.visibility = View.INVISIBLE
//        LoadingStatus.FAILED -> view.visibility = View.VISIBLE
//    }
//}
