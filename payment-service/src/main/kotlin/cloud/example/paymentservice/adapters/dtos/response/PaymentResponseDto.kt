package cloud.example.paymentservice.adapters.dtos.response

data class PaymentResponseDto(
    val paymentStatus: String,
    val transactionId: String,
    val orderId: Int,
    val amount: Double
)