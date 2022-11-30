package com.montfel.data.dto

import com.google.gson.annotations.SerializedName
import com.montfel.domain.model.Platform

data class PlatformDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String

) {
    fun toDomain() = Platform(
        id = id,
        name = name
    )
}
