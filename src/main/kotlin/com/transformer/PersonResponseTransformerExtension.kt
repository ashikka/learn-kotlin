package com.transformer

import com.dto.PersonResponse
import com.example.springkotlin.domain.Person

fun Person?.toPersonResponse (): PersonResponse{
    return PersonResponse(
            id = this?.id ?: 1L,
            fullName = "${this?.lastName}, ${this?.name}"
    )
}