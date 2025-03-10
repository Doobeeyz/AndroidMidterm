package com.example.midterm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.midterm.ui.theme.MidtermTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MidtermTheme {
                AppNav()
            }
        }
    }
}

@Composable
fun AppNav(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){ HomeScreen(navController)}
        composable("hobbies"){ HEMAScreen(navController)}


    }
}

@Composable
fun HEMAScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {
        Spacer(modifier = Modifier.height(48.dp))

        AsyncImage(
            model = "https://images.squarespace-cdn.com/content/v1/55b01d82e4b0ee47a1e0a740/1497380702994-54YQ0BNXI9QNZSIB5OG8/19055147_475788256091994_5054900722423178733_o.jpg?format=2500w",
            contentDescription = "Перейти на экран деталей",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate("details") }
        )
        Text(
            modifier = Modifier
                .padding(24.dp),
            text = "HEMA (Historical European Martial Arts) - historical European martial arts, based on the European martial tradition, which is being revived in our time on the basis of ancient manuscripts on fencing.",
            color = Color.White
        )
        Button(onClick = { navController.popBackStack()},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray
            ),
            modifier = Modifier
                .padding(16.dp)
                .width(200.dp)
                .height(80.dp)
        ) {
            Text(
                text = "Back",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Image(
            painter = painterResource(R.drawable.me),
            contentDescription = "me",
            modifier = Modifier
                .clip(CircleShape)
                .size(200.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.navigate("hobbies")},
            colors = ButtonDefaults.buttonColors(
               containerColor = Color.Gray
            ),
            modifier = Modifier
                .padding(16.dp)
                .width(200.dp)
                .height(80.dp)
        ) {
            Text(
                text = "My hobby",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold

            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppNav()
}