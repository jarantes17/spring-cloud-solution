package cloud.example.orderservice.application.dto.response

import cloud.example.orderservice.domain.data.entity.Order

class TransactionResponse(
    val order: Order,
    val amount: Double,
    val transactionId: String,
    val message: String
)