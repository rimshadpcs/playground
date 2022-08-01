package com.rimapps.PlayGround.view.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rimapps.PlayGround.view.activities.ui.theme.MvvmTesterTheme
import java.nio.file.Files.size

class DrawingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyDrawing()
        }
    }
}

@Composable
fun MyDrawing(){
    Canvas(
        modifier = Modifier
            .padding(20.dp)
            .size(500.dp)
    ){
        drawRect(
            color = Color.Gray,
            size = size
        )
        drawRect(color = Color.White,
        topLeft = Offset(150f,150f),
        size = Size(500f,500f),
        style = Stroke(
            width = 3.dp.toPx()
        )

        )

    }
}
