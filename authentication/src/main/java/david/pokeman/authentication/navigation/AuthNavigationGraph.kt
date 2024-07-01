package david.pokeman.authentication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import david.pokeman.authentication.LoginScreen
import david.pokeman.authentication.RegisterScreen

@Composable
fun AuthNavigationGraph(navController: NavHostController, onAuthComplete: () -> Unit) {
	NavHost(navController = navController, startDestination = Routes.LOGIN_SCREEN) {
		composable(Routes.LOGIN_SCREEN) {
			LoginScreen(onLoginSuccess = {
				onAuthComplete()
			})
		}
		composable("register") {
			RegisterScreen(onRegisterSuccess = {
				navController.navigate(Routes.LOGIN_SCREEN) {
					popUpTo(Routes.REGISTER_SCREEN) { inclusive = true }
				}
			})
		}
	}
}