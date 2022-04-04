package cloud.example.orderservice.application.ports.inbound

import cloud.example.orderservice.adapters.dtos.request.TransactionRequestDto
import cloud.example.orderservice.adapters.dtos.response.TransactionResponseDto

interface CreateOrderUseCase {
    fun createOrder(transactionRequestDto: TransactionRequestDto): TransactionResponseDto
}