package uz.usoft.composeexamples.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import uz.usoft.composeexamples.R

sealed class Screen(
    val screenName: String,
    @StringRes val titleResourceId: Int = -1,
    @DrawableRes val iconRes: Int = -1
) {
    object Auth : Screen("auth", -1) {
        object Launch : Screen("auth/launch", -1)
        object AuthEnterPhone : Screen("auth/phone", -1)
        object AuthEnterCode : Screen("auth/code/{${ArgPhoneNumber}}", -1) {
            fun addArg(arg: String) = "auth/code/$arg"
        }

        object AuthFillProfile : Screen("auth/profile", -1)

        const val ArgPhoneNumber = "phone_number"
    }

    object Main : Screen("main", -1) {
        object Home : Screen("main/home", -1) {
            val bottomMenus = listOf(Main, Marketing, Basket, MyCars, Profile)

            object Main : Screen("main/home/main", R.string.menu_main, R.drawable.ic_home)
            object Marketing :
                Screen("main/home/marketing", R.string.menu_marketing, R.drawable.ic_marketing)

            object Basket : Screen("main/home/basket", R.string.menu_basket, R.drawable.ic_basket)
            object MyCars : Screen("main/home/my_cars", R.string.menu_my_car, R.drawable.ic_my_cars)
            object Profile :
                Screen("main/home/profile", R.string.menu_profile, R.drawable.ic_profile)
        }

        object CarInsurance : Screen("main/car_insurance")
        object Osago : Screen("main/osago")
        object Kasko : Screen("main/kasko")
    }
}


