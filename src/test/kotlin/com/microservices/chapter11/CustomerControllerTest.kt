package com.microservices.chapter11

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `we should GET the customer list`() {
        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("\$[0].id").value(1))
                .andExpect(jsonPath("\$[0].name").value("kotlin"))
                .andDo(print())
    }

    @Test
    fun `we should get a customer by id`() {
        mockMvc.perform(get("/customer/1"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("\$.id").value(1))
                .andExpect(jsonPath("\$.name").value("kotlin"))
                .andDo(print())
    }

}