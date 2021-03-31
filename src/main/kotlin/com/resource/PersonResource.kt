package com.resource

import com.dto.AddPersonRequest
import com.dto.PersonResponse
import com.dto.UpdatePersonRequest
import org.springframework.http.ResponseEntity

interface PersonResource {
    fun findById(id:Long): ResponseEntity<PersonResponse?>
    fun findAll(): ResponseEntity<List<PersonResponse>>
    fun save(addPersonRequest: AddPersonRequest): ResponseEntity<PersonResponse>
    fun update(updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse>
    fun deleteById(id: Long): ResponseEntity<Unit>
}