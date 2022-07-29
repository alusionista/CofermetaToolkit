package br.com.cofermeta.toolkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.cofermeta.toolkit.ui.theme.LoginActivityTheme

class QueryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginActivityTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    QueryScreen()
                }
            }
        }
    }
}

@Composable
fun QueryScreen() {
    Column {
        QueryHeader()
        QueryBody()
    }
}
@Composable
fun QueryHeader() {
    Text(
        text = "Consulta de Pedidos",
        fontSize = 28.sp,
        modifier = Modifier
            .wrapContentWidth(Alignment.Start)
            .padding(all = 16.dp)
    )
}

@Composable
fun QueryBody() {
    Surface(color = Color.LightGray, modifier = Modifier
        .fillMaxWidth()
        .padding(all = 16.dp).clip(RoundedCornerShape(12.dp))){
        Box(modifier = Modifier.padding(16.dp)) {
            Column {
                Row(horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()) {
                    Image(painterResource(R.drawable.carretel_placeholder),
                        contentDescription = null,
                        modifier = Modifier.size(width = 172.dp, height = 172.dp).clip(RoundedCornerShape(12.dp))
                    )
                    Column() {
                        Column {
                            Text(text = "Código", fontSize = 14.sp)
                            Text(text = "654321", fontSize = 22.sp)
                        }
                        Column {
                            Text(text = "Código", fontSize = 14.sp)
                            Text(text = "654321", fontSize = 22.sp)
                        }
                        Column {
                            Text(text = "Código", fontSize = 14.sp)
                            Text(text = "654321", fontSize = 22.sp)
                        }
                    }
                }
                Column {
                    Text(text = "Descrição", fontSize = 14.sp)
                    Text(text = "Desforcímetro com Encaixe de 1 Polegada 1-78 7800NM SGT-9811 - SIGMA", fontSize = 22.sp)
                }
                Image(painterResource(R.drawable.ic_baseline_add_box_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 50.dp, height = 50.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginActivityTheme {
        QueryScreen()
    }
}