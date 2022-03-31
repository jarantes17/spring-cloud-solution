package cloud.example.orderservice.api.controller

import cloud.example.orderservice.application.dto.request.TransactionRequest
import cloud.example.orderservice.application.dto.response.TransactionResponse
import cloud.example.orderservice.application.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController(
    private val service: OrderService
) {

    @PostMapping("/bookOrder")
    fun bookOrder(@RequestBody request: TransactionRequest): TransactionResponse {
        return service.saveOrder(request)
    }

}