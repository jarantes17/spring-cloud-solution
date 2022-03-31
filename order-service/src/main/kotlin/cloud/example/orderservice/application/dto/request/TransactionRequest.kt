package cloud.example.orderservice.application.dto.request

import cloud.example.orderservice.domain.common.shared.Payment
import cloud.example.orderservice.domain.data.entity.Order

data class TransactionRequest(val order: Order, val payment: Payment)
