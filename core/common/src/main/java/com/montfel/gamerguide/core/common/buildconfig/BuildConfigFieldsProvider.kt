package com.montfel.gamerguide.core.common.buildconfig

interface BuildConfigFieldsProvider {
    operator fun invoke(): BuildConfigFields
}
