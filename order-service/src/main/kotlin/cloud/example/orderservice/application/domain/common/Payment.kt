package cloud.example.orderservice.application.domain.common

data class Payment(
    var paymentId: Int,
    var paymentStatus: String,
    var transactionId: String,
    var orderId: Int,
    var amount: Double
)
