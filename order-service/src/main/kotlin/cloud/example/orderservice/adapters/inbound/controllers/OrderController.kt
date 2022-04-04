package cloud.example.orderservice.adapters.inbound.controllers

import cloud.example.orderservice.adapters.dtos.request.TransactionRequestDto
import cloud.example.orderservice.adapters.dtos.response.TransactionResponseDto
import cloud.example.orderservice.application.services.OrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController(
    private val orderService: OrderService
) {

    @PostMapping("/bookOrder")
    fun bookOrder(@RequestBody request: TransactionRequestDto): TransactionResponseDto {
        return orderService.createOrder(request)
    }

}