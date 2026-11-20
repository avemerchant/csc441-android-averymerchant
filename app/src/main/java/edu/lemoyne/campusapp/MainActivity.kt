package edu.lemoyne.campusapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import edu.lemoyne.campusapp.ui.theme.CampusAppTheme

class MainActivity : ComponentActivity() {

    private val showcaseViewModel: ShowcaseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showcaseViewModel.refresh()
        enableEdgeToEdge()

        setContent {
            val showcaseState by showcaseViewModel.state.collectAsStateWithLifecycle()
            showcaseViewModel
            CampusAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScrapbookAppScreen(
                        showcaseState = showcaseState,
                        onRefreshShowcase = showcaseViewModel::refresh,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
