package com.montfel

interface DtoMapper<Domain> {
    fun toDomain(): Domain
}
