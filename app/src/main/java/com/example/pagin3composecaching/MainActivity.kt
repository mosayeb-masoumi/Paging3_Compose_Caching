package com.example.pagin3composecaching

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.pagin3composecaching.presentation.BeerScreen
import com.example.pagin3composecaching.presentation.BeerViewModel
import com.example.pagin3composecaching.ui.theme.Pagin3ComposeCachingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {



    // SOURCE = https://www.youtube.com/watch?v=AasI-0IRXUM&t=1s

    //at first time api will be called and get data from server  then data will be saved in dp

    // after getting data if we turn off internet we will see the all list saved in db


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pagin3ComposeCachingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val viewModel = hiltViewModel<BeerViewModel>()
                    val beers = viewModel.beerPagingFlow.collectAsLazyPagingItems()

                    BeerScreen(beers = beers)
                }
            }
        }
    }
}

