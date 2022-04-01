package cloud.example.paymentservice.application.services

import cloud.example.paymentservice.adapters.dtos.PaymentDto
import cloud.example.paymentservice.application.ports.inbound.CancelPaymentUseCase
import cloud.example.paymentservice.application.ports.inbound.DoPaymentUseCase

class PaymentService : DoPaymentUseCase, CancelPaymentUseCase {

    override fun doPayment(paymentDto: PaymentDto): PaymentDto {
        TODO("Not yet implemented")
    }

    override fun cancelPayment(paymentId: Int) {
        TODO("Not yet implemented")
    }
}