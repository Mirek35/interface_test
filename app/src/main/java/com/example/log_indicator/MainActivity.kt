package com.example.log_indicator


import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview


import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyContent(applicationContext)
        }
    }
}

@Composable
fun MyContent(context: Context) {

    // Delaracja zmiennej  val licznik
    // Inicjacja  wart. zerową
    val context = LocalContext.current
    val licznik = remember { mutableStateOf(0) }
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    //////////////////////////////////////////////////////////

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login into your Univect account",
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)

        )
        Spacer(modifier = Modifier.height(300.dp))
////////////////////////////////////////////////////////////////////////////////////////////////

        OutlinedTextField(
            value = login,
            onValueChange = { login = it },
            label = { Text(text = "enter your  login") },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "person")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp, top = 10.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "enter your  password") },
            leadingIcon = {
                Icon(Icons.Default.Info, contentDescription = "password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp, top = 10.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            )
        )


/////////////////stary loging //////////////////////////////////////////////////////////////////////////////
//        CreateButton(text = "Loging") {
//            licznik.value += 1
//            if (licznik.value > 3)
//                licznik.value = 0
//
//
//   /////////////////////////////////////////////
        OutlinedButton(
            onClick = { logged(login, password,context) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue,
                contentColor = Color.White
            )

        ) {
            Text(
                text = "Login",
                textAlign = TextAlign.Center
            )
        }

        //////////////////////////////////////////
        // Spacja
        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "Aplication loading",
            fontFamily = FontFamily.Default,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row() {

            //Paski postępu
            LinearProgressIndicator(
                progress = 0.0f,
                modifier = Modifier
                    .height(8.dp)
                    .width(60.dp),
                backgroundColor = Color.LightGray

            )

            //   Spacja

            Spacer(modifier = Modifier.width(20.dp))
            //drugi pasek
            LinearProgressIndicator(
                progress = 0.0f,
                modifier = Modifier
                    .height(8.dp)
                    .width(60.dp),
                backgroundColor = Color.LightGray
            )
            Spacer(modifier = Modifier.width(20.dp))
            //trzeci pasek
            LinearProgressIndicator(
                progress = 0.0f,
                modifier = Modifier
                    .height(8.dp)
                    .width(60.dp),
                backgroundColor = Color.LightGray
            )
            Spacer(modifier = Modifier.width(20.dp))
        }
        Spacer(modifier = Modifier.height(50.dp))

        // Displaying the mCounter value as Text
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(15)) //zaokrąglenie rogów
                .background(Color.DarkGray),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ) {
            Text(text = licznik.value.toString(), color = Color.White, fontSize = 20.sp)
            Text(text = "/3", color = Color.White, fontSize = 20.sp)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Checking connection to server", color = Color.White, fontSize = 20.sp)
        }

    }
}


fun logged(login: String, password: String, context: Context) {
    if (login == "Mirek" && password == "123") {
        Toast.makeText(context, "Logowanie powiodło się", Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(context, "Logowanie nie popwiodl się", Toast.LENGTH_SHORT).show()
    }


}

@Preview
@Composable
fun ComposablePreview(){
    MyContent(context = LocalContext.current)
}


