package com.service

import com.dao.PersonDao
import com.dto.AddPersonRequest
import com.dto.PersonResponse
import com.dto.UpdatePersonRequest
import com.transformer.AddPersonRequestTransformer
import org.springframework.stereotype.Service

@Service
class PersonManangementServiceImpl(private val personDao: PersonDao,
                                   private val addPersonRequestTransformer: AddPersonRequestTransformer) : PersonManangementService {
    override fun findById(id: Long): PersonResponse? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<PersonResponse> {
        TODO("Not yet implemented")
    }

    override fun save(addPersonRequest: AddPersonRequest): PersonResponse {
        TODO("Not yet implemented")
    }

    override fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }
}