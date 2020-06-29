package com.sampleapp.data.response

data class APIResponse(
    val rows: List<Row>,
    val title: String
)

data class Row(
        val description: String,
        val imageHref: String,
        val title: String
)