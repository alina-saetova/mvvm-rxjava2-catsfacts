package ru.itis.cats_facts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import ru.itis.cats_facts.di.Injectable
import ru.itis.cats_facts.view.FavouritesFragment
import ru.itis.cats_facts.view.CategoriesFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(),
    HasAndroidInjector,
    Injectable {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector() = dispatchingAndroidInjector

    private val titles = arrayOf("Search", "Favourites")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        view_pager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tabs, view_pager,
            TabConfigurationStrategy { tab: TabLayout.Tab, position: Int ->
                tab.text = titles[position]
            }
        ).attach()
    }
}


class ViewPagerAdapter(mainActivity: MainActivity) : FragmentStateAdapter(mainActivity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return CategoriesFragment()
            1 -> return FavouritesFragment()
        }
        return FavouritesFragment()
    }

}
