package com.example.dynamiccolors

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dynamiccolors.ui.theme.DynamicColorsTheme
import com.example.dynamiccolors.ui.theme.MyGrey
import com.example.dynamiccolors.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DynamicColorsTheme {
                Scaffold{innerPadding->
                    Column(modifier = Modifier
                        .padding(innerPadding)
                        .padding(20.dp)
                        .fillMaxWidth()){
                        TopSec()
                    }
                }
            }
        }
    }
}

@Composable
fun TopSec() {
    var txt:String by remember { mutableStateOf("") }
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Box (
            modifier = Modifier.clip(RoundedCornerShape(20.dp))
        ){
        Row{
        BasicTextField(value = txt, onValueChange = {txt=it}, modifier = Modifier
            .background(MyGrey)
            .padding(20.dp)
            .width(270.dp),singleLine = true
        )

        }
        }
        IconButton(onClick = { /*TODO*/ }) {
            Image(painter = painterResource(id = R.drawable.profile), contentDescription = "")
        }
    }

}