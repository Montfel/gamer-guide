package com.montfel.gamerguide.data.dto

import com.google.gson.annotations.SerializedName
import com.montfel.gamerguide.data.DtoMapper
import com.montfel.gamerguide.domain.model.Platform

data class PlatformDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String

) : DtoMapper<Platform> {
    override fun toDomain() = Platform(
        id = id,
        name = name
    )
}
