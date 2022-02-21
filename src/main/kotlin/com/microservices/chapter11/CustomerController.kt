package com.microservices.chapter11

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ConcurrentHashMap

@RestController
class CustomerController {
    companion object {
        val initialCustomers = arrayOf(Customer(1, "kotlin"), Customer(2, "spring"), Customer(3, "microservice"), Customer(4, "openshift"))
        val customers = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy(Customer::id))
    }

    @GetMapping("/customers")
    fun getCustomers() = customers.values.toList()

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id: Int) = customers[id]
}