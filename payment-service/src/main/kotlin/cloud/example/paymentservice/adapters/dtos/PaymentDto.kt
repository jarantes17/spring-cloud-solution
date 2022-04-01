package cloud.example.paymentservice.adapters.dtos

data class PaymentDto(
    val paymentStatus: String,
    val transactionId: String,
    val orderId: Int,
    val amount: Double
)