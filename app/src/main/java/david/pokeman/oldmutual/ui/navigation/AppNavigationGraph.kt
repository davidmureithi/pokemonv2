package david.pokeman.oldmutual.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import david.pokeman.oldmutual.ui.screens.DetailsScreen
import david.pokeman.oldmutual.ui.screens.HomeScreen

@Composable
fun AppNavigationGraph(navController: NavHostController) {
	NavHost(navController = navController, startDestination = Routes.HOME_SCREEN) {
		composable(Routes.HOME_SCREEN) {
			HomeScreen(navController = navController)
		}
		
		composable(Routes.DETAILS_SCREEN) {
			DetailsScreen()
		}
	}
}