package cloud.example.paymentservice.adapters.outbound.persistence.repositories.jpa

import cloud.example.paymentservice.adapters.outbound.persistence.entities.PaymentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PaymentJpaRepository : JpaRepository<PaymentEntity, Int> {
    fun findByOrderId(orderId: Int): PaymentEntity
}