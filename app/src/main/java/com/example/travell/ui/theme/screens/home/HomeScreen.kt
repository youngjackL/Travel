package com.example.travell.ui.theme.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cuin.toursafric.navigation.ROUTE_ADD_PRODUCT
import com.cuin.toursafric.navigation.ROUTE_VIEW_PRODUCT
import com.cuin.toursafric.navigation.ROUTE_VIEW_UPLOAD

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(

    )
    {

        LocalContext.current
//        var productdata=productviewmodel(navController,context)

        Text(text = "TravelsRUs",
            color = Color.Cyan,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_ADD_PRODUCT)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "Travel Details")
        }
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_VIEW_PRODUCT)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "View Details")
        }
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_VIEW_UPLOAD)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "View Uploaded Details")
        }


    }



}

//@Preview
//@Composable
//fun Homepreview() {
//    HomeScreen(rememberNavController())
//}