package cloud.example.orderservice.application.service

import cloud.example.orderservice.application.dto.request.TransactionRequest
import cloud.example.orderservice.application.dto.response.TransactionResponse
import cloud.example.orderservice.domain.common.shared.Payment
import cloud.example.orderservice.domain.data.entity.Order
import cloud.example.orderservice.domain.data.repository.OrderRepository
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class OrderService(
    private val repository: OrderRepository,
    @Lazy private val template: RestTemplate
) {

    var logger: Logger = LoggerFactory.getLogger(OrderService::class.java)

    @Value("\${microservice.payment-service.endpoints.endpoint.uri}")
    lateinit var endpointUrl: String

    @Throws(JsonProcessingException::class)
    fun saveOrder(request: TransactionRequest): TransactionResponse {
        val order: Order = request.order
        val payment = request.payment
        payment.orderId = order.id
        payment.amount = order.price

        logger.info("Order-Service Request : " + ObjectMapper().writeValueAsString(request))
        val paymentResponse = template.postForObject(endpointUrl, payment, Payment::class.java)
        val response =
            if (paymentResponse!!.paymentStatus == "success") "payment processing successful and order placed" else "there is a failure in payment api , order added to cart"
        logger.info(
            "Order Service getting Response from Payment-Service : " + ObjectMapper().writeValueAsString(
                response
            )
        )
        repository.save(order)
        return TransactionResponse(order, paymentResponse.amount, paymentResponse.transactionId, response)
    }

}