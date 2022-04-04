package cloud.example.orderservice.adapters.dtos.response

import cloud.example.orderservice.application.domain.Order

class TransactionResponseDto(
    val order: Order,
    val amount: Double,
    val transactionId: String,
    val message: String
)