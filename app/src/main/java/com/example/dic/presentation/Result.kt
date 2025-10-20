package com.example.dic.presentation

sealed class Result<out T> {
    data class Success<out T>(val success: T) : Result<T>()
    data class Error(val error: String) : Result<Nothing>()
    object Loading: Result<Nothing>()
}