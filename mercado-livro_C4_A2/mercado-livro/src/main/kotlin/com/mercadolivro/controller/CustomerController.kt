package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController {

    val customers = mutableListOf<CustomerModel>()

    @GetMapping
    fun getAll(@RequestParam nome: String?): List<CustomerModel> {
        nome?.let {
            return customers.filter { it.nome.contains(nome,true) }
        }
        return customers
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest){

        val id:String = if(customers.isEmpty()) "1" else (customers.last().id.toInt() + 1).toString()

        customers.add(CustomerModel(id,customer.nome,customer.email))
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String?): CustomerModel {
        return customers.filter { it.id == id }.first()        // Recupera e retorna o Objt Customer usando ID
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)          //Tudo OK mas sem Retorno
    fun update(@PathVariable id: String, @RequestBody customer: PostCustomerRequest){
        return customers.filter { it.id == id }.first().let {
            it.nome = customer.nome
            it.email = customer.email
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)          //Tudo OK mas sem Retorno
    fun update(@PathVariable id: String){
        customers.removeIf{it.id == id}
    }
}