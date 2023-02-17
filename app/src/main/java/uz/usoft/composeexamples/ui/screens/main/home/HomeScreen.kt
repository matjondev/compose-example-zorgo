package uz.usoft.composeexamples.ui.screens.main.home

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import uz.usoft.composeexamples.ui.basic_components.app_bars.ZorGoBottomNavigationBar
import uz.usoft.composeexamples.ui.navigation.Screen
import uz.usoft.composeexamples.ui.screens.auth.BoxWithMainBackground
import uz.usoft.composeexamples.ui.screens.main.home.main.MainPage
import uz.usoft.composeexamples.ui.theme.Blue800

@Composable
fun HomeScreen(navController: NavController) {

    val d: Context =LocalContext.current

    val bottomNavController = rememberNavController()

    Column(modifier = Modifier.background(MaterialTheme.colors.background)) {
        NavHost(
            navController = bottomNavController,
            startDestination = Screen.Main.Home.Main.screenName,
            modifier = Modifier.weight(1f)
        ) {
            composable(Screen.Main.Home.Main.screenName) { MainPage(navController = navController) }
            composable(Screen.Main.Home.Marketing.screenName) {}
            composable(Screen.Main.Home.Basket.screenName) {}
            composable(Screen.Main.Home.MyCars.screenName) {}
            composable(Screen.Main.Home.Profile.screenName) {}
        }

        ZorGoBottomNavigationBar(
            navController = bottomNavController,
            modifier = Modifier
                .navigationBarsPadding(),
            onItemClicked = { screen ->
                bottomNavController.navigate(screen.screenName) {
                    popUpTo(bottomNavController.graph.findStartDestination().id) {
                        saveState = true
                    }

                    launchSingleTop = true
                    restoreState = true
                }
            })
    }


}