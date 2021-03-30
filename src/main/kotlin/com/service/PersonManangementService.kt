package com.service

import com.dto.AddPersonRequest
import com.dto.PersonResponse
import com.dto.UpdatePersonRequest

interface PersonManangementService {
    fun findById(id:Long): PersonResponse?
    fun findAll(): List<PersonResponse>
    fun save(addPersonRequest: AddPersonRequest): PersonResponse
    fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse
    fun deleteById(id: Long)
}