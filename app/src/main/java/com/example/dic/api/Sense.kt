package com.example.dic.api

data class Sense(
    val antonyms: List<Any>,
    val definition: String,
    val examples: List<String>,
    val quotes: List<Quote>,
    val subsenses: List<Any>,
    val synonyms: List<Any>,
    val tags: List<String>
)