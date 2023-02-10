package uz.usoft.composeexamples.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import uz.usoft.composeexamples.ui.MainActivityViewModel
import uz.usoft.composeexamples.ui.screens.auth.enter_phone.AuthEnterPhoneScreen
import uz.usoft.composeexamples.ui.screens.auth.LaunchScreen
import uz.usoft.composeexamples.ui.screens.auth.enter_code.AuthEnterCodeScreen
import uz.usoft.composeexamples.ui.screens.auth.fill_profile.AuthFillProfileScreen
import uz.usoft.composeexamples.ui.screens.main.home.HomeScreen
import uz.usoft.composeexamples.ui.screens.main.home.main.car_insurance.CarInsuranceScreen
import uz.usoft.composeexamples.ui.screens.main.home.main.car_insurance.kasko.KaskoScreen
import uz.usoft.composeexamples.ui.screens.main.home.main.car_insurance.osago.OsagoScreen
import uz.usoft.composeexamples.ui.theme.Blue800

@Composable
fun NavHostScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        val viewModel = hiltViewModel<MainActivityViewModel>()
        val navController = rememberNavController()
        val uiController = rememberSystemUiController()

        val fm = LocalFocusManager.current
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            fm.clearFocus(force = true)
        }

        val startScreen = if (viewModel.isRegistered) Screen.Main else Screen.Auth
        NavHost(navController = navController, startDestination = startScreen.screenName) {
            authGraph(navController, uiController)
            mainGraph(navController, uiController)
        }
    }
}

fun NavGraphBuilder.authGraph(
    navController: NavController,
    systemUiController: SystemUiController
) {
    navigation(startDestination = Screen.Auth.Launch.screenName, Screen.Auth.screenName) {
        composable(Screen.Auth.Launch.screenName) {
            systemUiController.setSystemDarkIcons(false)
            LaunchScreen(navController)
        }
        composable(Screen.Auth.AuthEnterPhone.screenName) {
            systemUiController.setSystemDarkIcons(true)
            AuthEnterPhoneScreen(navController, hiltViewModel())
        }
        composable(Screen.Auth.AuthEnterCode.screenName) {
            AuthEnterCodeScreen(
                phoneNumber = it.arguments?.getString(Screen.Auth.ArgPhoneNumber) ?: "",
                navController = navController
            )
        }
        composable(Screen.Auth.AuthFillProfile.screenName) {
            AuthFillProfileScreen(
                navController = navController
            )
        }
    }
}

fun NavGraphBuilder.mainGraph(
    navController: NavController,
    systemUiController: SystemUiController
) {
    navigation(startDestination = Screen.Main.Home.screenName, route = Screen.Main.screenName) {
        composable(Screen.Main.Home.screenName) {
            systemUiController.setStatusBarColor(Color.Transparent, darkIcons = true)
            systemUiController.setNavigationBarColor(Blue800, darkIcons = false)
            HomeScreen(navController)
        }
        composable(Screen.Main.CarInsurance.screenName) {
            systemUiController.setNavigationBarColor(
                Color.Transparent,
                darkIcons = true,
                navigationBarContrastEnforced = false
            )
            CarInsuranceScreen(navController = navController)
        }
        composable(Screen.Main.Osago.screenName) {
            OsagoScreen(navController = navController)
        }
        composable(Screen.Main.Kasko.screenName) {
            KaskoScreen(navController = navController)
        }
    }
}


private fun SystemUiController.setSystemDarkIcons(isDarkIcons: Boolean) {
    setSystemBarsColor(
        Color.Transparent, darkIcons = isDarkIcons,
        isNavigationBarContrastEnforced = false,
    )
}