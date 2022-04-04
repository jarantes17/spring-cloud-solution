package cloud.example.orderservice.application.services

import cloud.example.orderservice.adapters.dtos.request.TransactionRequestDto
import cloud.example.orderservice.adapters.dtos.response.TransactionResponseDto
import cloud.example.orderservice.application.domain.Order
import cloud.example.orderservice.application.domain.common.Payment
import cloud.example.orderservice.application.ports.inbound.CreateOrderUseCase
import cloud.example.orderservice.application.ports.outbound.OrderRepositoryPort
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.annotation.Lazy
import org.springframework.web.client.RestTemplate

@RefreshScope
class OrderService : CreateOrderUseCase {

    var logger: Logger = LoggerFactory.getLogger(OrderService::class.java)

    @Autowired
    @Lazy
    lateinit var template: RestTemplate

    @Autowired
    lateinit var orderRepository: OrderRepositoryPort

    @Value("\${microservice.payment-service.endpoints.endpoint.uri}")
    lateinit var endpointUrl: String

    @Throws(JsonProcessingException::class)
    override fun createOrder(transactionRequestDto: TransactionRequestDto): TransactionResponseDto {
        val order: Order = transactionRequestDto.order
        val payment = transactionRequestDto.payment
        payment.orderId = order.id
        payment.amount = order.price

        logger.info("Order-Service Request : " + ObjectMapper().writeValueAsString(transactionRequestDto))
        val paymentResponse = template.postForObject(endpointUrl, payment, Payment::class.java)
        val response =
            if (paymentResponse!!.paymentStatus == "success") "payment processing successful and order placed" else "there is a failure in payment api , order added to cart"
        logger.info(
            "Order Service getting Response from Payment-Service : " + ObjectMapper().writeValueAsString(
                response
            )
        )
        orderRepository.save(order)

        return TransactionResponseDto(order, paymentResponse.amount, paymentResponse.transactionId, response)
    }
}