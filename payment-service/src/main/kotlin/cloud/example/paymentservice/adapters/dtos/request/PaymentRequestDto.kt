package cloud.example.paymentservice.adapters.dtos.request

data class PaymentRequestDto(
    val paymentStatus: String,
    val transactionId: String,
    val orderId: Int,
    val amount: Double
)