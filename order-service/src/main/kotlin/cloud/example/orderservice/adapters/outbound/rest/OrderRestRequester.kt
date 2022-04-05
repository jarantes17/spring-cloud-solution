package cloud.example.orderservice.adapters.outbound.rest

import cloud.example.orderservice.application.domain.common.Payment
import cloud.example.orderservice.application.ports.outbound.OrderRestRequesterPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component("orderRestRequester")
@RefreshScope
class OrderRestRequester: OrderRestRequesterPort {

    @Autowired
    @Lazy
    lateinit var template: RestTemplate

    @Value("\${microservice.payment-service.endpoints.endpoint.uri}")
    lateinit var endpointUrl: String

    override fun postPayment(payment: Payment): Payment? {
        return template.postForObject(endpointUrl, payment, Payment::class.java)
    }
}