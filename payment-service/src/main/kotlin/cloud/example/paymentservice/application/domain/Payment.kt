package cloud.example.paymentservice.application.domain

data class Payment(
    var paymentStatus: String,
    var transactionId: String,
    val orderId: Int,
    val amount: Double
)