package com.not.drunk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.not.drunk.databinding.ActivityMainBinding
import com.not.drunk.viewmodel.NODViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var binding: ActivityMainBinding

    private val sharedViewModel: NODViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.apply {
            activityNODViewModel = sharedViewModel
            lifecycleOwner = this@MainActivity
        }

        //setupActionBarWithNavController(navController)

        binding.maxNoOfWords = MAX_NO_OF_QUESTIONS

        //Navigate the screen based on the question type
        //The fragment id is fetch from view model
        /*https://medium.com/android-news/sending-events-from-viewmodel-to-activities-fragments-the-right-way-26bb68502b24*/
        sharedViewModel.screenNavigationObserver.observe(this, Observer { event ->
            event?.getContentIfNotHandledOrReturnNull()?.let {
                navController.navigate(sharedViewModel.getIDOfNextScreen(it))
            }
        })

    }

    /**
     * Handle navigation when the user chooses Up from the action bar.
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}