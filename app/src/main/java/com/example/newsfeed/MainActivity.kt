package com.example.newsfeed


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsfeed.R
import com.example.newsfeed.ui.theme.NewsFeedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsFeedTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    mainscreen()
                }
            }
        }
    }
}

@Composable
fun mainscreen(){
    Scaffold(topBar = { TopAppBar(title = {Text("News App",color = Color.White)},backgroundColor = Color(0xFF1976D2)) },
        content = {Screen() })

}


@Composable
fun Description(title : String , info : String ){


    Column(modifier = Modifier.padding(6.dp)) {
        Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = info)
    }

}





@Composable
fun Downcard(title : String , info : String ){
    Row(verticalAlignment = Alignment.CenterVertically){
        Description(title  , info )

    }

}


@Composable
fun Itemcard(title : String , info : String  , id :Int ) {
    Column( ) {
        Card( modifier = Modifier
            .padding(10.dp)
            .height(250.dp), elevation = 4.dp , shape = RoundedCornerShape(10.dp) ,) {
            Column {

                Image(painter = painterResource(id = id), contentDescription = "location" , modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)

                    , contentScale = ContentScale.Crop)
                Downcard(title, info )
            }
        }
    }

}



@Composable
fun Screen(){


    var heading  = listOf(
        "Who Will win the Chess Grandmaster Title",
        "Top 10 Apps you msut install in your mobile",
        "New Programming Language which is faster than C++",
        "Coding vs Development",
        "Android 14 is offically released"
    )
    var desc = listOf(
        "World Finals is not so far ....",
        "These 10 Apps will boost productivity in daily life ...",
        "Engineers made a new language faster than c++ ....",
        "Are You Confuse about to start with Coding or Development ? ....",
        "Andriod 14 is now available to these phones ....."
    )
    var ids = listOf(
        R.drawable.pexels_george_becker_131616,
        R.drawable.pexels_lisa_fotios_1092644,
        R.drawable.pexels_markus_spiske_1921326,
        R.drawable.pexels_markus_spiske_2004161,
        R.drawable.pexels_noah_erickson_404280
    )
    Column(modifier = Modifier

        .padding(start = 14.dp, top = 10.dp, end = 14.dp, bottom = 10.dp)) {


        LazyColumn(){
            itemsIndexed(heading) { index, item ->
                Itemcard(
                    title = heading[index],
                    info = desc[index],
                    id = ids[index]
                )
            }
        }


    }


}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsFeedTheme {
        Screen()
    }
}

