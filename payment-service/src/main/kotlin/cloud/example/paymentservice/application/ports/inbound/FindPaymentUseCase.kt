package cloud.example.paymentservice.application.ports.inbound

import cloud.example.paymentservice.application.domain.Payment

interface FindPaymentUseCase {
    fun findPaymentHistoryByOrderId(orderId: Int): Payment
}