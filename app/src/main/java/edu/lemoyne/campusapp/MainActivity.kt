package edu.lemoyne.campusapp

import android.R.attr.text
import android.content.res.Configuration
import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.pm.ShortcutInfoCompat
import edu.lemoyne.campusapp.ui.theme.CampusAppTheme
import edu.lemoyne.campusapp.ui.theme.Purple40
import edu.lemoyne.campusapp.ui.theme.Purple80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CampusAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// --- Class 7: Step 1: A counter that remembers ---
@Composable
fun CounterDemo() {
    var count by remember { mutableStateOf(0) }

    Button(
        onClick = { count++ }
    ) {
        Text(text = "Tapped $count times")
    }
}

// --- Class 6: Step 1: My own screen ---
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // --- Class 7: Step 2: The list lives in state
    val pages = remember {
        mutableStateListOf(
            "Christmas Time 2025",
            "Mother's Day 2026",
            "Becca and the Tall Boys Concert",
            "Move In - Senior Year"
        )
    }

    // --- Class7: Step 3: What typed lives in state ---
    var newPage by remember { mutableStateOf("") }

    // ---Class 6: Step 3: A column, so things stack ---
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 24.dp)
    ) {
        CounterDemo()
        Spacer(modifier = Modifier.height(8.dp))
        // --- Lab 6: Task 3: A picture of my own ---
        Image(
            painter = painterResource(id = R.drawable.header),
            contentDescription = "Scrapbooking supplies",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        // --- Class 6: Step 4: Real styling ---
        // --- Lab 6: Task 1 ---
        Text(
            text = "Scrapbook Log",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(8.dp))
        // --- Lab 6: Task 1 ---
        Text(
            text = "Pages I have made this year",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        // --- Class 7: Step 3: Text field
        OutlinedTextField(
            value = newPage,
            onValueChange = { newPage = it },
            label = { Text("Page Name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Class 7: Step 4: The button changes the state ---
        Button(onClick = {
            pages.add(newPage)
            newPage = ""
        }) {
            Text("Add page")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // --- Class 7: Step 2: Draw whatever is in the list ---
        Text(text = "${pages.size} Pages Created", fontWeight = FontWeight.Bold)

        for (page in pages) {
            Text(text = page, fontSize = 18.sp)
        }

        // --- Lab 6 · Task 2: footer ---
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Last updated September 2026",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

// --- Class 6: Step 2: Preview ---
@Preview
@Composable
fun HomeScreenPreview() {
    CampusAppTheme() {
        HomeScreen()
    }
}

// --- Lab 6: Task 4: Dark mode preview
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenDarkPreview() {
    CampusAppTheme {
        Surface {
            HomeScreen()
        }
    }
}
