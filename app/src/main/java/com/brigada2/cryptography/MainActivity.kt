package com.brigada2.cryptography

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brigada2.cryptography.code.lab1.Control
import com.brigada2.cryptography.ui.theme.CryptographyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptographyTheme {
                val inputNum = remember{ mutableStateOf("") }
                val parametrK = remember{ mutableStateOf("") }
                val parametrC = remember{ mutableStateOf("") }
                var result = remember{mutableStateOf("")}

                Scaffold(topBar = {
                    @OptIn(ExperimentalMaterial3Api::class)
                    TopAppBar(
                        title = {Text("(p - 1) - факторизация", fontSize = 28.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)},
                        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
                    )
                },
                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ){
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .border(2.dp, color = Color(0xff00ff), shape = RoundedCornerShape(10.dp))){
                            Text("Введите параметры", fontSize = 28.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(10.dp).fillMaxWidth())

                            Row(Modifier.fillMaxWidth()) {
                                Text("Входное число", modifier = Modifier.weight(2f).padding(10.dp))
                                TextField(
                                    inputNum.value,
                                    onValueChange = { inputNum.value = it },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                    modifier = Modifier.weight(3f).padding(10.dp)

                                )
                            }

                            Row(Modifier.fillMaxWidth()){
                                Text("Параметр K", modifier = Modifier.weight(2f).padding(10.dp))
                                TextField(parametrK.value,
                                    onValueChange = {parametrK.value = it},
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                    modifier = Modifier.weight(3f).padding(10.dp)
                                )

                            }

                            Row(Modifier.fillMaxWidth()){
                                Text("Параметр C", modifier = Modifier.weight(2f).padding(10.dp))
                                TextField(parametrC.value,
                                    onValueChange = {parametrC.value = it},
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                    modifier = Modifier.weight(3f).padding(10.dp)
                                )

                            }

                            Button(onClick = {
                                result.value = Control.calculate(inputNum.value, parametrK.value, parametrC.value);
                            },
                                modifier = Modifier.align(Alignment.CenterHorizontally)){
                                Text("Рассчитать", fontSize = 28.sp)
                            }


                            Text("Результаты", fontSize = 28.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(top = 40.dp)
                                    .fillMaxWidth())
                            Row(Modifier.fillMaxWidth()){
                                Text("Простые делители", modifier = Modifier.weight(2f).padding(10.dp))
                                Text(result.value, fontSize = 28.sp, modifier = Modifier.weight(3f).padding(10.dp))
                            }


                        }
                    }
                }
            }
        }
    }
}
