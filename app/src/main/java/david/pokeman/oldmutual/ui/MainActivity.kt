package david.pokeman.oldmutual.ui

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import david.pokeman.authentication.navigation.AuthNavigationGraph
import david.pokeman.oldmutual.ui.navigation.AppNavigationGraph
import david.pokeman.oldmutual.ui.theme.PokeManTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	@RequiresApi(Build.VERSION_CODES.S)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		installSplashScreen()
		setContent {
			PokeManTheme {
				Surface(
					modifier = Modifier.fillMaxSize()
				) {
					PokeMan()
				}
			}
		}
	}
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun PokeMan() {
	val navController = rememberNavController()
	var isUserLoggedIn by remember { mutableStateOf(false) }
	
	if (isUserLoggedIn) {
		AppNavigationGraph(navController = navController)
	} else {
		AuthNavigationGraph(navController = navController) {
			isUserLoggedIn = true
		}
	}
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
fun PokeManPreview() {
	PokeMan()
}