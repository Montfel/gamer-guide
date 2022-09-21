package com.montfel.gamerguide.data

interface DtoMapper<Domain> {
    fun toDomain(): Domain
}
