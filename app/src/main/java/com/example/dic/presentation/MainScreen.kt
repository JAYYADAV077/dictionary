package com.example.dic.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dic.MainActivity
import com.example.dic.api.ApiDataClass
import com.example.dic.api.En
import com.example.dic.api.Sense

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel
) {


    val data = mainViewModel.data.observeAsState()

    var input by remember { mutableStateOf("") }

    Column(
        modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Spacer(modifier.height(20.dp))

        Row(
            modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedTextField(
                value = input,
                onValueChange = { input = it },
                shape = RoundedCornerShape(10.dp)
            )

            Button(onClick = {
                mainViewModel.apiCall(word = input, language = En.english)
            }) {
                Text(text = "Search")
            }
        } //row end

        Spacer(modifier.height(10.dp))

        when (val result = data.value) {
            is Result.Success -> Detail(data = result.success)
            is Result.Error -> result.error
            is Result.Loading -> CircularProgressIndicator()
            else -> {}
        }

    }
}

@Composable
fun Detail(modifier: Modifier = Modifier, data: ApiDataClass) {

    Text(
        text = data.word,
        fontSize = 50.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        textAlign = TextAlign.Start
    )



            }


