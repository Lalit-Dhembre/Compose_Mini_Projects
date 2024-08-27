package com.example.tressurehunterstatemanagement

import android.app.AlertDialog
import android.icu.text.CaseMap.Title
import android.inputmethodservice.Keyboard
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tressurehunterstatemanagement.ui.theme.TressureHunterStateManagementTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TressureHunterStateManagementTheme {
                Box(modifier = Modifier.fillMaxSize()){
                }
                Column(
                    modifier = Modifier.fillMaxSize().background(Color.Black),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(id = R.drawable.steer),
                        contentDescription = "Background image",
                        contentScale = ContentScale.Fit,)
                    val context = LocalContext.current
                    val treasureFound = remember { mutableIntStateOf(0) }
                    val direction  = remember { mutableStateOf("North") }
                    val hp = remember { mutableIntStateOf(10) }
                   
                   Text(text = "Treasures Found: ${treasureFound.intValue}", color = Color.Red, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                   Text(text = "Direction Facing: ${direction.value}", color = Color.Red, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = "hp: ${hp.intValue}", color = Color.Red, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Row{
                        Button(onClick = {
                            if(Random.nextBoolean()){
                                treasureFound.intValue +=1
                                direction.value = "East"
                                Toast.makeText(context,"YEAH!! You Found a Treasure Captain! ",Toast.LENGTH_SHORT).show()
                            }
                            else{
                                hp.intValue -= 2
                                Toast.makeText(context,"Noo!! You got a Hit -2 hp",Toast.LENGTH_SHORT).show()
                            }
                        }) {
                            Text(text = "East")
                        }
                        Spacer(modifier = Modifier.width(20.dp))
                        Button(onClick = {
                            if(Random.nextBoolean()){
                                treasureFound.intValue +=1
                                direction.value = "West"
                                Toast.makeText(context,"YEAH!! You Found a Treasure Captain! ",Toast.LENGTH_SHORT).show()
                            }
                            else{
                                hp.intValue -= 2
                                Toast.makeText(context,"Noo!! You got a Hit -2 hp",Toast.LENGTH_SHORT).show()
                            }
                        }) {
                            Text(text = "West")
                        }
                    }
                   Row {
                    Button(onClick = {
                       if(Random.nextBoolean()){
                           treasureFound.intValue +=1
                           direction.value = "South"
                           Toast.makeText(context,"YEAH!! You Found a Treasure Captain! ",Toast.LENGTH_SHORT).show()
                       }
                       else{
                           hp.intValue -= 2
                           Toast.makeText(context,"Noo!! You got a Hit -2 hp",Toast.LENGTH_SHORT).show()
                       }
                   }) {
                       Text(text = "South")
                   }
                       Spacer(modifier = Modifier.width(20.dp))
                    Button(onClick = {
                       if(Random.nextBoolean()){
                           treasureFound.intValue +=1
                           direction.value = "North"
                           Toast.makeText(context,"YEAH!! You Found a Treasure Captain! ",Toast.LENGTH_SHORT).show()
                       }
                       else{
                           hp.intValue -= 2
                           Toast.makeText(context,"Noo!! You got a Hit -2 hp",Toast.LENGTH_SHORT).show()
                       }
                   }) {
                       Text(text = "North")
                   }

                   }
                    if(hp.intValue == 0){
                        AlertDialog(
                            title = { Text(text = "Game Over!")},
                            text = { Text(text = "Your Score is ${treasureFound.value}")},
                            onDismissRequest = {
                                hp.intValue = 5
                                treasureFound.intValue = 0
                                direction.value = "NORTH"
                            },
                            confirmButton = {
                                TextButton(onClick = { hp.intValue = 5
                                    treasureFound.intValue = 0
                                    direction.value = "NORTH" }) {
                                    Text(text = "Ok")
                                }
                            },
                            dismissButton = {
                                TextButton(onClick = { hp.intValue = 10
                                    treasureFound.intValue = 0
                                    direction.value = "NORTH" }) {
                                    Text(text = "Cancel")
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
