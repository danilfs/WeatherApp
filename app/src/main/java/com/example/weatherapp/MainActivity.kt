package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.experiment.MainBroadCastReceiver
import com.example.weatherapp.experiment.contentProvider.ContentProviderFragment
import com.example.weatherapp.presentation.history.HistoryFragment
import com.example.weatherapp.presentation.main.MainFragment
import com.example.weatherapp.presentation.maps.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val receiver = MainBroadCastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        FirebaseMessaging.getInstance().token.addOnCompleteListener {
//            if (it.isComplete) {
//                val firebaseToken = it.result.toString()
//            }
//        }
        if (savedInstanceState == null) {
            openFragment(MainFragment.newInstance())
//            openFragment(ThreadsFragment.newInstance())
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    private fun openFragmentAddBackStack(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_screen_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_history -> {
                supportFragmentManager.apply {
                    beginTransaction()
                        .add(R.id.container, HistoryFragment.newInstance())
                        .addToBackStack("")
                        .commitAllowingStateLoss()
                }
                true
            }
            R.id.menu_content_provider -> {
                openFragmentAddBackStack(ContentProviderFragment())
                true
            }
            R.id.menu_maps -> {
                openFragmentAddBackStack(SearchFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
