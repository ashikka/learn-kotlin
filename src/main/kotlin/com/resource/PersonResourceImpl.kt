package com.resource

import com.dto.AddPersonRequest
import com.dto.PersonResponse
import com.dto.UpdatePersonRequest
import com.resource.PersonResourceImpl.Companion.BASE_PERSON_URL
import com.service.PersonManangementService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_PERSON_URL])
class PersonResourceImpl(private val personManangementService: PersonManangementService) : PersonResource {

    @GetMapping("/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<PersonResponse?> {
        val personResponse: PersonResponse? = this.personManangementService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(personResponse)
    }

    @GetMapping
    override fun findAll(): ResponseEntity<List<PersonResponse>> = ResponseEntity.ok(this.personManangementService.findAll())

    @PostMapping
    override fun save(@RequestBody addPersonRequest: AddPersonRequest): ResponseEntity<PersonResponse> {
        val personResponse = this.personManangementService.save(addPersonRequest)
        return ResponseEntity
                .created(URI.create(BASE_PERSON_URL.plus("/${personResponse.id}")))
                .body(personResponse)
    }

    @PutMapping
    override fun update(@RequestBody updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse> {
        return ResponseEntity.ok(this.personManangementService.update((updatePersonRequest)))
    }

    @DeleteMapping("/{id}")
    override fun deleteById(id: Long): ResponseEntity<Unit> {
        this.personManangementService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    companion object{
        const val BASE_PERSON_URL: String = "/api/v1/person"
    }
}