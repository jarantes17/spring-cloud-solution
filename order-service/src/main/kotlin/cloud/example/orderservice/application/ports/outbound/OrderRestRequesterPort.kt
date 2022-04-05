package cloud.example.orderservice.application.ports.outbound

import cloud.example.orderservice.application.domain.common.Payment

interface OrderRestRequesterPort {
    fun postPayment(payment: Payment): Payment?
}