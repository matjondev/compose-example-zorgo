package uz.usoft.composeexamples.ui.basic_components.app_bars

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import uz.usoft.composeexamples.ui.navigation.Screen
import uz.usoft.composeexamples.ui.theme.Blue800
import uz.usoft.composeexamples.ui.theme.ComposeExamplesTheme
import uz.usoft.composeexamples.ui.theme.ZorGoTypography
import uz.usoft.composeexamples.ui.theme.toDisabled

@Composable
fun ZorGoBottomNavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClicked: (Screen) -> Unit,
    items: List<Screen> = Screen.Main.Home.bottomMenus,
) {
    BottomNavigation(
        modifier = Modifier
            .then(modifier)
            .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)),
        elevation = 0.dp,
        backgroundColor = Blue800,
        contentColor = MaterialTheme.colors.onPrimary,
    ) {

        items.forEach { screen ->
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            val isSelected =
                currentDestination?.hierarchy?.any { it.route == screen.screenName } == true
            BottomNavigationItem(
                modifier = Modifier.align(Alignment.Top),
                selected = isSelected,
                onClick = { onItemClicked(screen) },
                icon = {
                    Icon(
                        painter = painterResource(id = screen.iconRes),
                        contentDescription = screen.screenName,
                        tint = if (isSelected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onPrimary.toDisabled()
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = screen.titleResourceId),
                        color = if (isSelected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onPrimary.toDisabled()
                    )
                }
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewZorGoBottomAppBar() {
    ComposeExamplesTheme() {
        ZorGoTypography {
            val navController = rememberNavController()
            ZorGoBottomNavigationBar(navController, onItemClicked = { screen ->
                navController.navigate(screen.screenName) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }

                    launchSingleTop = true
                    restoreState = true
                }
            })
        }
    }
}