package com.danielaboros.appandroid.objects

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchObject(
    val total: Int,
    val objectIDs: List<Int>?
)