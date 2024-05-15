package com.example.tourus.navigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cuin.toursafric.navigation.ROUTE_ADD_PRODUCT
import com.cuin.toursafric.navigation.ROUTE_HOME
import com.cuin.toursafric.navigation.ROUTE_LOGIN
import com.cuin.toursafric.navigation.ROUTE_REGISTER
import com.cuin.toursafric.navigation.ROUTE_UPDATE_PRODUCT
import com.cuin.toursafric.navigation.ROUTE_VIEW_PRODUCT
import com.cuin.toursafric.navigation.ROUTE_VIEW_UPLOAD
import com.example.travell.ui.theme.screens.home.HomeScreen
import com.example.travell.ui.theme.screens.login.LoginScreen
import com.example.travell.ui.theme.screens.products.AddProductsScreen
import com.example.travell.ui.theme.screens.products.UpdateProductsScreen
import com.example.travell.ui.theme.screens.products.ViewProductsScreen
import com.example.travell.ui.theme.screens.products.ViewUploadsScreen
import com.example.travell.ui.theme.screens.register.RegisterScreen


@Composable
fun AppNavHost(modifier: Modifier=Modifier,navController:NavHostController= rememberNavController(),startDestination:String= ROUTE_LOGIN) {

    NavHost(navController = navController, modifier=modifier, startDestination = startDestination ){
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }

        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_ADD_PRODUCT) {
            AddProductsScreen(navController)
        }
        composable(ROUTE_VIEW_PRODUCT){
            ViewProductsScreen(navController)
        }
        composable("$ROUTE_UPDATE_PRODUCT/{id}"){ passedData ->
            UpdateProductsScreen(navController,passedData.arguments?.getString("id")!!)
        }
        composable(ROUTE_VIEW_UPLOAD){
            ViewUploadsScreen(navController)
        }
    }

}
