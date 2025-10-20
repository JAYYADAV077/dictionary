package com.example.dic.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dic.api.ApiDataClass
import com.example.dic.api.RetrofitInstance
import kotlinx.coroutines.launch
import kotlin.math.log

class MainViewModel: ViewModel() {

    val apiInterfaceObj = RetrofitInstance.apiInterfaceObj //interface obj

    private val _data = MutableLiveData<Result<ApiDataClass>>()

    val data: LiveData<Result<ApiDataClass>> = _data

    fun apiCall(word: String,language: String){

        _data.value = Result.Loading

        try {

            viewModelScope.launch {

                Log.i("aappii", "Coroutine started")
                val response = apiInterfaceObj.getEntry(word = word, language = language)

                Log.i("aappii", "call ,wait for reponse")
                if (response.isSuccessful){
                    Log.i("aappii",response.body().toString())
                    response.body()?.let {
                        _data.value = Result.Success(it)
                    }
                } else {
                    Log.i("aappii", "Response Failed: ${response.code()} ${response.message()}")
                    _data.value = Result.Error("Data is not Loading")
                }

            }
        }
        catch (e: Exception) {
            _data.value = Result.Error("Data is not Loading")
        }

    }

}