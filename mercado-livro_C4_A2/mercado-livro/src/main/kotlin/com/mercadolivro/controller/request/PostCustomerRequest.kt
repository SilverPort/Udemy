package com.mercadolivro.controller.request

import com.mercadolivro.model.CustomerModel

data class PostCustomerRequest (var nome: String, var email: String){
    fun toCustomerModel(): CustomerModel = CustomerModel(nome = this.nome, email = this.email)
}
