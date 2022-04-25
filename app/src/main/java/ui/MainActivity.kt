package ui

import adapterViewPager.ViewPagerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.myapp.zaptv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configTabLayout()
    }


    private fun configTabLayout() {

        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter
        adapter.addFragment(MovieFragment(), "Filmes")
        adapter.addFragment(SerieFragment(), "Séries")
        adapter.addFragment(FavoriteFragment(), "Favoritos")

        binding.viewPager.offscreenPageLimit = adapter.itemCount
        val mediator = TabLayoutMediator(
            binding.tabs,
            binding.viewPager
        ) { tab: TabLayout.Tab, position: Int ->
            tab.text = adapter.getTitle(position)
        }
        mediator.attach()
    }
}