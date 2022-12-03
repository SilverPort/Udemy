package com.mercadolivro.extension

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel{
    return CustomerModel(nome = this.nome, email = this.email)
}
fun PostCustomerRequest.toCustomerModel(id:String): CustomerModel{
    return CustomerModel(id = id, nome = this.nome, email = this.email)
}