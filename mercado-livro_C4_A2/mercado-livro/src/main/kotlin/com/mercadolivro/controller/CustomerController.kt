package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.servece.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController(val customerService: CustomerService) {



    @GetMapping
    fun getAll(@RequestParam nome: String?): List<CustomerModel> {
        return customerService.getAll(nome)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest){
        customerService.create(customer)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String?): CustomerModel {
        return customerService.getCustomer(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)          //Tudo OK mas sem Retorno
    fun update(@PathVariable id: String, @RequestBody customer: PostCustomerRequest){
        return customerService.update(id, customer)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)          //Tudo OK mas sem Retorno
    fun update(@PathVariable id: String){
        customerService.update(id)
    }
}