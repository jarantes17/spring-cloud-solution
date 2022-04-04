package cloud.example.orderservice.adapters.dtos.request

import cloud.example.orderservice.application.domain.Order
import cloud.example.orderservice.application.domain.common.Payment

data class TransactionRequestDto(val order: Order, val payment: Payment)
