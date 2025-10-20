package com.example.dic.api

data class ApiDataClass(
    val entries: List<Entry>,
    val source: Source,
    val word: String
)