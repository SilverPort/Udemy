package com.mercadolivro.servece

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service
@Service
class CustomerService {
    val customers = mutableListOf<CustomerModel>()


    fun getAll(nome: String?): List<CustomerModel> {
        nome?.let {
            return customers.filter { it.nome.contains(nome,true) }
        }
        return customers
    }

    fun create(customer: PostCustomerRequest){

        customer
    }

    fun getCustomer( id: String?): CustomerModel {
        return customers.filter { it.id == id }.first()        // Recupera e retorna o Objt Customer usando ID
    }

    fun update( id: String, customer: PostCustomerRequest){
        return customers.filter { it.id == id }.first().let {
            it.nome = customer.nome
            it.email = customer.email
        }
    }

    fun update( id: String){
        customers.removeIf{it.id == id}
    }
}