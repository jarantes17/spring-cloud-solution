package cloud.example.paymentservice.application.domain

data class Payment(
    val paymentStatus: String,
    val transactionId: String,
    val orderId: Int,
    val amount: Double
)