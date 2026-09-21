package com.example.retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.retrofit.retrofit.FilmApi
import com.example.retrofit.ui.theme.RetrofitTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        }
        val retrofit = Retrofit.Builder().baseUrl("http://www.omdbapi.com").addConverterFactory(
            GsonConverterFactory.create()
        ).build()
        val filmApi = retrofit.create(FilmApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val film = filmApi.getFilm()
            runOnUiThread {  }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Ui() {

}

