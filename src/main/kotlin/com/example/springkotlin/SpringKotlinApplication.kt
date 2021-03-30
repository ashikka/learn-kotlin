package com.example.springkotlin

import com.example.springkotlin.domain.Person
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping

@SpringBootApplication
@RestController
class SpringKotlinApplication{

	@GetMapping
	fun hi(): Person{
		return Person(name="Ashikka")
	}
}

fun main(args: Array<String>) {
	runApplication<SpringKotlinApplication>(*args)
}
