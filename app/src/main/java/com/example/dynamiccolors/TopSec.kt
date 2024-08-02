package com.example.dynamiccolors

import android.content.res.Resources.Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dynamiccolors.ui.theme.MyGrey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopSec() {
    var txt:String by remember { mutableStateOf("") }
    Row (
        modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ){
        OutlinedTextField(
            value = txt, onValueChange = { txt = it },
            placeholder = { Text(text = "Search here") },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.width(300.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.2f),
                focusedContainerColor = MyGrey,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = MyGrey,
            )
        )
        IconButton(onClick = { /*TODO*/ }) {
            Image(painter = painterResource(id = R.drawable.profile), contentDescription = "")
        }
    }

}