package cloud.example.paymentservice.adapters.outbound.persistence.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "PAYMENT_TB")
class PaymentEntity(
    @Id
    @GeneratedValue
    var paymentId: Int? = 0,
    val paymentStatus: String,
    val transactionId: String,
    val orderId: Int,
    val amount: Double
)