package com.example.travell.ui.theme.screens.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.travell.data.productviewmodel
import com.cuin.toursafric.model.Upload
import com.cuin.toursafric.navigation.ROUTE_UPDATE_PRODUCT
import com.example.travell.R


@Composable
fun ViewUploadsScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        val context = LocalContext.current
        val productRepository = productviewmodel(navController, context)


        val emptyUploadState = remember { mutableStateOf(Upload("","","","","")) }
        val emptyUploadsListState = remember { mutableStateListOf<Upload>() }

        val uploads = productRepository.viewUploads(emptyUploadState, emptyUploadsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Up" +
                    "loads",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn {
                items(uploads){
                    UploadItem(
                        name = it.name,
                        quantity = it.quantity,
                        price = it.price,
                        id = it.id,
                        navController = navController,
                        productRepository = productRepository
                    )
                }
            }
        }
    }
}


@Composable
fun UploadItem(
    name: String, quantity: String, price: String, id: String, navController: NavHostController,
    productRepository: productviewmodel
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = quantity)
        Text(text = price)
//        Image(
//            painter = rememberAsyncImagePainter(imageUrl),
//            contentDescription = null,
//            modifier = Modifier.size(128.dp)
//        )
        Image(painter = painterResource(id = R.drawable.jelly),
            contentDescription = null ,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Button(onClick = {
            productRepository.deleteProduct(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate("$ROUTE_UPDATE_PRODUCT/$id")
        }) {
            Text(text = "Update")
        }
    }
}
