package com.azrinurvani.paging3andjetpackcompose.model

import kotlinx.serialization.Serializable

@Serializable //dengan ini semua variable harus sama dengan response
data class Urls(
    val regular: String
)
