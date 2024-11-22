package com.vooazdomain.Vooaz.telas.resetpassword

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.componentes.ComposePinInput
import com.vooazdomain.Vooaz.componentes.ComposePinInputStyle

@Composable
fun ForgotPasswordPin(navController: NavController){
    BackgroundForgotPasswordPin()
    ContentForgotPasswordPin(navController)
}
@Composable
fun BackgroundForgotPasswordPin(){
    Box(modifier = Modifier.background(color = Color(0xFF2C58B0)).fillMaxSize())
    Box(
        modifier = Modifier.fillMaxSize(),


        ){
        Image(painterResource(R.drawable.womanforgotpasswordpin), contentDescription = "Woman forgot password image", modifier = Modifier.height(400.dp).width(300.dp).align(Alignment.TopCenter).padding(top= 70.dp))
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentForgotPasswordPin(navController: NavController){
    var pin by remember { mutableStateOf("") }
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),

        ){
        Icon(Icons.Filled.Close, contentDescription = "Voltar", modifier = Modifier.size(50.dp).padding(top=20.dp).clickable { navController.popBackStack() })}

    Column(
        modifier= Modifier.fillMaxHeight().fillMaxWidth().padding(top=230.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        Text("Verificar Pin?", fontSize = 30.sp, fontWeight = FontWeight.Bold, color= Color(color = 0xFFF4B942))
        Text("• Entre com o codigo que foi enviado ao seu email", fontSize= 10.sp, modifier = Modifier.padding(top = 10.dp))
        Row (modifier=Modifier.padding(top = 20.dp)) {
            ComposePinInput(

                value = pin,
                mask = '*',
                cellBorderColor = Color.Black,
                focusedCellBorderColor = Color(0xFFF4B942),
                onValueChange = {
                    pin = it
                },
                cellSize = 70.dp,
                onPinEntered = {
                    Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
                },

                style = ComposePinInputStyle.BOX
            )
        }

        Button( onClick = {
            navController.navigate("ChangePasswordScreen")
        },
            shape =   RoundedCornerShape(20.dp),
            modifier = Modifier.padding(top = 30.dp).width(200.dp).height(50.dp),
            colors =  ButtonDefaults.buttonColors(containerColor = Color(0xFFF4B942)),
        ) {
            Text("Verificar", fontWeight = FontWeight.Bold)
        }



    }

}
@Preview(showBackground = true, heightDp = 800, widthDp = 360)
@Composable
fun ForgotPasswordPinPreview(){
    BackgroundForgotPasswordPin()
    ContentForgotPasswordPin(rememberNavController())

}