package edu.lemoyne.campusapp

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.lemoyne.campusapp.ui.theme.CampusAppTheme


// --- Class 8: Step 2: One rule book ---
const val MAX_NAME_LENGTH = 40

fun validatePageName(input: String, existing: List<String>): String? {
    val name = input.trim()
    return when {
        name.isEmpty() -> "Enter a name for your page"
        // --- Lab 8: Task 2: A rule of your own ---
        name.all { it.isDigit() } -> "A name can't be only numbers"
        // --- Lab 8: Task 1: A minimum length --
        name.length < 3 -> "Too short - at least 3 characters"
        name.length > MAX_NAME_LENGTH -> "Keep it to $MAX_NAME_LENGTH characters or fewer"
        existing.any { it.equals(name, ignoreCase = true) } -> "\"$name\" is already on the list"
        else -> null
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

// --- Class 9: Step 2: One owner for the data ---
@Composable
fun ScrapbookAppScreen(modifier: Modifier = Modifier) {
    // --- Class 7: Step 2: The list lives in state ---
    val pages = remember {
        mutableStateListOf(
            "Christmas Time 2025",
            "Mother's Day 2026",
            "Becca and the Tall Boys Concert",
            "Move In - Senior Year"
        )
    }

    // --- Class 9: Step 4: Which screen is showing is just state ---
    var currentScreen by rememberSaveable { mutableStateOf("home") }

    when (currentScreen) {
        "home" -> HomeScreen(
            pages = pages,
            onAddPage = { pages.add(it) },
            onSeeAll = { currentScreen = "list" },
            // --- Lab 9: Task 2: Wiring it up myself ---
            onAbout = { currentScreen = "about" }
        )

        "list" -> ListScreen(
            pages = pages,
            onBack = { currentScreen = "home" },
            modifier = modifier
        )

        // --- Lab 9: Task 2: Wiring it up myself ---
        "about" -> AboutScreen(
            onBack = { currentScreen = "home" },
            modifier = modifier
        )
    }
}

// --- Class 6: Step 1: My own screen ---
@Composable
fun HomeScreen(
    pages: MutableList<String>,
    onAddPage: (String) -> Unit,
    onSeeAll: () -> Unit,
    // --- Lab 9: Task 2: Wiring it up myself ---
    onAbout: () -> Unit,
    modifier: Modifier = Modifier
) {
    // --- Class 7: Step 3: What typed lives in state ---
    var newPage by remember { mutableStateOf("") }

    // --- Class 8: Step 3: The error message lives in state too ---
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // ---Class 6: Step 3: A column, so things stack ---
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 24.dp)
    ) {
//        CounterDemo()
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
            // --- Class 8: Step 4: The field itself pushes back ---
            onValueChange = {
                newPage = it.take(MAX_NAME_LENGTH)
                errorMessage = null
            },
            label = { Text("Page name") },
            singleLine = true,
            isError = errorMessage != null,
            modifier = Modifier.fillMaxWidth()
        )

        // --- CLass 8: Step 3: Show the problem ---
        errorMessage?.let { message ->
            Text(
                text = message,
                color = MaterialTheme.colorScheme.error,
                fontSize = 14.sp
            )
        }
        // --- Lab 7: Task 4: A live character counter ---
        Text(
            text = "${newPage.length} / $MAX_NAME_LENGTH",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        // Class 7: Step 4: The button changes the state ---
        Button(
            onClick = {
                // --- Class 8: Step 3: Check before you add ---
                val problem = validatePageName(newPage, pages)
                if (problem == null) {
                    // --- Class 9: Step 2: Ask the owner to add it
                    onAddPage(newPage.trim())
                    newPage = ""
                } else {
                    errorMessage = problem
                }
            },
            // --- Class 8: Step 5: The sign on the door, not the lock
            enabled = newPage.isNotBlank()
        ) {
            Text("Add page")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // --- Class 7: Step 2: Draw whatever is in the list ---
        // --- Lab 7: Task 2: Singular and plural ---
        Text(
            text = if (pages.size == 1) "1 Page Created" else "${pages.size} Pages Created",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // --- Class 9: Step 5: A way to the second screen ---
        Button(
            onClick = onSeeAll
        ) {
            Text(text = "See all scrapbook pages")
        }

        // --- Lab 9: Task 2: Wiring it up myself ---
        Button(
            onClick = onAbout
        ) {
            Text(text = "About")
        }

        // --- Lab 6 · Task 2: footer ---
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Last updated October 2026",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

// --- Class 9: Step 3: The second screen
@Composable
fun ListScreen(
    pages: List<String>,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    // --- Class 9: Step 6: The phone's back button goes home too ---
    BackHandler { onBack() }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        TextButton(onClick = onBack) {
            Text(text = "Back to Home Page")
        }

        Text(
            text = "All pages",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // --- Lab 9: Task 1: Count on the list screen
        Text(
            text = if (pages.size == 1) "1 Page Created" else "${pages.size} Pages Created",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        for (page in pages) {
            Text(text = page, fontSize = 18.sp)
        }
    }
}

// --- Lab 9: Task 2: A third screen
@Composable
fun AboutScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler { onBack() }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        TextButton(onClick = onBack) {
            Text("Back")
        }

        Text(
            text = "About",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "The list of pages keeps track of the scrapbook pages I've created this year.")
        Text(text = "Built for CSC 441 by Avery Merchant.")
    }
}

// --- Class 6: Step 2: Preview ---
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CampusAppTheme() {
        HomeScreen(
            pages = remember {
                mutableStateListOf(
                    "Christmas Time 2025",
                    "Mother's Day 2026",
                    "Becca and the Tall Boys Concert",
                    "Move In - Senior Year"
                )
            },
            onAddPage = {},
            onSeeAll = {},
            // --- Lab 9: Task 2: Wiring it up myself ---
            onAbout = {}
        )
    }
}

// --- Lab 6: Task 4: Dark mode preview
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenDarkPreview() {
    CampusAppTheme {
        Surface {
            HomeScreen(
                pages = remember {
                    mutableStateListOf(
                        "Christmas Time 2025",
                        "Mother's Day 2026",
                        "Becca and the Tall Boys Concert",
                        "Move In - Senior Year"
                    )
                },
                onAddPage = {},
                onSeeAll = {},
                // --- Lab 9: Task 2: Wiring it up myself ---
                onAbout = {}
            )
        }
    }
}

// --- Class 9: Step 7: Preview the list screen
@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    CampusAppTheme() {
        ListScreen(
            pages = remember {
                mutableStateListOf(
                    "Christmas Time 2025",
                    "Mother's Day 2026",
                    "Becca and the Tall Boys Concert",
                    "Move In - Senior Year"
                )
            },
            onBack = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    CampusAppTheme() {
        AboutScreen(
            onBack = {}
        )
    }
}
