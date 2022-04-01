package cloud.example.paymentservice.application.ports.inbound

import cloud.example.paymentservice.adapters.dtos.PaymentDto

interface DoPaymentUseCase {
    fun doPayment(paymentDto: PaymentDto): PaymentDto
}