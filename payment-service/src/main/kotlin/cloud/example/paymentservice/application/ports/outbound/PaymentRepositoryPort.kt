package cloud.example.paymentservice.application.ports.outbound

import cloud.example.paymentservice.application.domain.Payment

interface PaymentRepositoryPort {
    fun save(payment: Payment): Payment
}