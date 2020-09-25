package com.aplitsoft.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.aplitsoft.newsapp.Data.NewsApiService
import com.aplitsoft.newsapp.R.id.nav_host
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = findNavController(nav_host)
        val apiService = NewsApiService()
        GlobalScope.launch(Dispatchers.Main){
            val currentWeatherResponse = apiService.getLastNewsAsync().await()
           Log.e("RESPONSE", currentWeatherResponse.articles[0].title)
        }
    }
}