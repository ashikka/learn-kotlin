package com.service

import com.dao.PersonDao
import com.dto.AddPersonRequest
import com.dto.PersonResponse
import com.dto.UpdatePersonRequest
import com.example.springkotlin.domain.Person
import com.transformer.AddPersonRequestTransformer
import com.transformer.toPersonResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PersonManangementServiceImpl(private val personDao: PersonDao,
                                   private val addPersonRequestTransformer: AddPersonRequestTransformer) : PersonManangementService {

    override fun findById(id: Long): PersonResponse? = this.findPersonById(id).toPersonResponse()


    override fun findAll(): List<PersonResponse> = this.personDao.findAll().map(Person::toPersonResponse)

    override fun save(addPersonRequest: AddPersonRequest): PersonResponse {

        return this.saveOrUpdate(
                addPersonRequestTransformer.transform(addPersonRequest)
        )

    }

    override fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse {
        val person = this.findPersonById(updatePersonRequest.id) ?: throw IllegalAccessException("{$updatePersonRequest.id} not found")
        return this.saveOrUpdate(person.apply {
            this.name = updatePersonRequest.name
            this.lastName = updatePersonRequest.lastName
        })
    }

    override fun deleteById(id: Long) {
        this.personDao.deleteById(id)
    }

    private fun findPersonById (id: Long): Person? = this.personDao.findByIdOrNull(id)

    private  fun saveOrUpdate (person: Person): PersonResponse = this.personDao.save(person).toPersonResponse()
}