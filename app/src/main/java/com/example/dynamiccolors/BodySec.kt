package com.example.dynamiccolors

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Info(
    val img: Int,
    val name: String,
    val time: String,
    val title: String,
    val desc: String
)

fun InfoList(): List<Info> {
    return listOf(
        Info(R.drawable.profile,"Sagnik","20 min ago","Title","Description"),
        Info(R.drawable.profile,"Rahul","20 min ago","Title","Description"),
        Info(R.drawable.profile,"Vijay","20 min ago","Title","Description"),
    )
}

@Preview
@Composable
fun InfoCard(info: Info){
    Card(
        modifier = Modifier.clip(RoundedCornerShape(20.dp)).padding(bottom = 20.dp),
        onClick = {}
    ){
        Column (
            modifier = Modifier.padding(20.dp,15.dp)
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Image(painter = painterResource(id = R.drawable.profile), contentDescription = "", modifier = Modifier
                        .size(60.dp)
                        .clip(
                            RoundedCornerShape(50.dp)
                        ))
                    Column (
                        modifier = Modifier.padding(start = 10.dp)
                    ){
                        Text(text = info.name, fontSize = 18.sp)
                        Text(text = info.time, fontSize = 12.sp)
                    }
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Star, contentDescription = "",
                        Modifier
                            .size(60.dp))
                }
            }
            Column (
                modifier = Modifier.padding(top = 10.dp)
            ){
            Text(text = info.title, fontSize = 28.sp)
            Text(text = info.desc, fontSize = 16.sp, modifier = Modifier.padding(top = 10.dp))
            }
        }
    }
}

@Composable
fun BodySection(info: List<Info> = InfoList()) {
    LazyColumn{
        items(info.size){
            InfoCard(info = InfoList()[it])
        }
    }
}