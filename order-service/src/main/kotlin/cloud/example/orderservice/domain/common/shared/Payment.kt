package cloud.example.orderservice.domain.common.shared

data class Payment(
    var paymentId: Int,
    var paymentStatus: String,
    var transactionId: String,
    var orderId: Int,
    var amount: Double
)
