package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus

@RestController
@RequestMapping("customer")
class CustomerController {

    val customers = mutableListOf<CustomerModel>()

    @GetMapping
    fun getAll(): List<CustomerModel> {
        return customers
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest){

        val id:String = if(customers.isEmpty()) "1" else (customers.last().id.toInt() + 1).toString()

        customers.add(CustomerModel(id,customer.nome,customer.email))
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customers.filter { it.id == id }.first()        // Recupera e retorna o Objt Customer usando ID
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)          //Mostra que foi tudo OK mas não Retorna nada
    fun update(@PathVariable id: String, @RequestBody customer: PostCustomerRequest){
        return customers.filter { it.id == id }.first().let {
            it.nome = customer.nome
            it.email = customer.email
        }
    }
}