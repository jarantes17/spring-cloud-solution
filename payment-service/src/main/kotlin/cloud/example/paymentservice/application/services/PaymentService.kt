package cloud.example.paymentservice.application.services

import cloud.example.paymentservice.adapters.dtos.request.PaymentRequestDto
import cloud.example.paymentservice.adapters.dtos.response.PaymentResponseDto
import cloud.example.paymentservice.application.domain.Payment
import cloud.example.paymentservice.application.ports.inbound.DoPaymentUseCase
import cloud.example.paymentservice.application.ports.inbound.FindPaymentUseCase
import cloud.example.paymentservice.application.ports.outbound.PaymentRepositoryPort
import com.fasterxml.jackson.databind.ObjectMapper
import org.modelmapper.ModelMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import kotlin.random.Random

class PaymentService() : DoPaymentUseCase, FindPaymentUseCase {

    @Autowired
    lateinit var paymentRepository: PaymentRepositoryPort

    @Autowired
    lateinit var modelMapper: ModelMapper

    var logger: Logger = LoggerFactory.getLogger(PaymentService::class.java)

    override fun doPayment(paymentDto: PaymentRequestDto): PaymentResponseDto {
        val payment = modelMapper.map(paymentDto, Payment::class.java)
        payment.paymentStatus = paymentProcessing()

        logger.info("Payment-Service Request : {}", ObjectMapper().writeValueAsString(payment))

        return modelMapper.map(paymentRepository.save(payment), PaymentResponseDto::class.java)
    }

    override fun findPaymentHistoryByOrderId(orderId: Int): Payment {
        val payment: Payment = paymentRepository.findByOrderId(orderId)
        logger.info("paymentService findPaymentHistoryByOrderId : {}", ObjectMapper().writeValueAsString(payment))
        return payment
    }

    companion object {
        fun paymentProcessing(): String {
            return if (Random.nextBoolean()) "success" else "false"
        }
    }

}