package com.montfel.gamerguide.feature.data.model.dto

import com.google.gson.annotations.SerializedName

data class PlatformDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String
)
