package cloud.example.orderservice.application.services

import cloud.example.orderservice.adapters.dtos.request.TransactionRequestDto
import cloud.example.orderservice.adapters.dtos.response.TransactionResponseDto
import cloud.example.orderservice.application.domain.Order
import cloud.example.orderservice.application.ports.inbound.CreateOrderUseCase
import cloud.example.orderservice.application.ports.outbound.OrderRepositoryPort
import cloud.example.orderservice.application.ports.outbound.OrderRestRequesterPort
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class OrderService(
    private val orderRepository: OrderRepositoryPort,
    private val orderRestRequester: OrderRestRequesterPort
) : CreateOrderUseCase {

    var logger: Logger = LoggerFactory.getLogger(OrderService::class.java)

    @Throws(JsonProcessingException::class)
    override fun createOrder(transactionRequestDto: TransactionRequestDto): TransactionResponseDto {
        val order: Order = transactionRequestDto.order
        val payment = transactionRequestDto.payment
        payment.orderId = order.id
        payment.amount = order.price

        logger.info("Order-Service Request : " + ObjectMapper().writeValueAsString(transactionRequestDto))

        val paymentResponse = orderRestRequester.postPayment(payment)
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