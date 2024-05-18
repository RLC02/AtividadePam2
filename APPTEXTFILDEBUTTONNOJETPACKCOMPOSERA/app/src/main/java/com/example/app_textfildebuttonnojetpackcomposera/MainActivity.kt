package com.example.app_textfildebuttonnojetpackcomposera

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplicativobotes03_04.ui.theme.white
import com.example.app_textfildebuttonnojetpackcomposera.ui.theme.APPTEXTFILDEBUTTONNOJETPACKCOMPOSERATheme
import com.example.app_textfildebuttonnojetpackcomposera.ui.theme.BlueButtonColors
import com.example.app_textfildebuttonnojetpackcomposera.ui.theme.GreenButtonColors
import com.example.app_textfildebuttonnojetpackcomposera.ui.theme.RedButtonColors
import com.example.app_textfildebuttonnojetpackcomposera.ui.theme.YelllowButtonColors
import java.lang.RuntimeException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            APPTEXTFILDEBUTTONNOJETPACKCOMPOSERATheme {
                App()
            }
        }
    }
}

@Composable
fun TextField() {
    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Nome do Aluno: ") }
    )
}


@Composable
private fun App(){
    var nome  by remember{ mutableStateOf("")}
    val imageModifier = Modifier
        .size(150.dp)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = white,
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_etec),
                contentDescription = stringResource(id = R.string.logo_etec),
                modifier = imageModifier
            )
            Greeting(name = "JetPack")

            Row(
                Modifier.fillMaxWidth(),
                Arrangement.Center
            ){
                TextField()
            }
            ActionButton(
                text = "Nota MB",
                buttonColors = BlueButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                Log.d(ContentValues.TAG, "Nota MB!")
            }

            ActionButton(
                text = "Nota B",
                buttonColors = GreenButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                Log.i(ContentValues.TAG, "Nota B!")
            }

            ActionButton(
                text = "Nota R",
                buttonColors = YelllowButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                Log.w(ContentValues.TAG, "Nota R!")
            }

            ActionButton(
                text = "Nota I",
                buttonColors = RedButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                Log.e(ContentValues.TAG, "Nota I!")
            }
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
){
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ){
        Text(text = text)
    }
}

@Preview(showBackground = true, widthDp = 150, heightDp = 200)
@Composable
fun AppPreview(){
    APPTEXTFILDEBUTTONNOJETPACKCOMPOSERATheme{
        App()
    }
}

@Preview(showBackground = true, widthDp = 120)
@Composable
fun ActionButtonPreview(){
    ActionButton(text = "Cadastrar") {

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "ATIVIDADE DE PAM 2",
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Bold
        ),
        color = MaterialTheme.colorScheme.secondary
    )
}