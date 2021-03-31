package com.transformer

import com.dto.AddPersonRequest
import com.example.springkotlin.domain.Person
import org.springframework.stereotype.Component

@Component
class AddPersonRequestTransformer: Transformer<AddPersonRequest, Person> {
    override fun transform(source: AddPersonRequest): Person {
        return(
                Person(
                        name = source.name,
                        lastName = source.lastName
                )
                )
    }

}