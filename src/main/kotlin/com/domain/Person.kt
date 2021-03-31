package com.example.springkotlin.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.SequenceGenerator


@Entity
data class Person(
        @Id
        @SequenceGenerator(name= PERSON_SEQUENCE, sequenceName = PERSON_SEQUENCE, initialValue = 1, allocationSize = 1 )
        val id: Long = 1,
        var name: String = "",
        var lastName: String? = null){

    companion object{
        const val PERSON_SEQUENCE: String = "PERSON_SEQUENCE"
    }
}
