package cloud.example.paymentservice.adapters.outbound.persistence.repositories

import cloud.example.paymentservice.adapters.outbound.persistence.repositories.jpa.PaymentJpaRepository
import cloud.example.paymentservice.application.domain.Payment
import cloud.example.paymentservice.application.ports.outbound.PaymentRepositoryPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class PaymentRepository(
    private val paymentJpaRepository: PaymentJpaRepository
) : PaymentRepositoryPort {

    override fun save(payment: Payment): Payment {
        TODO("Not yet implemented")
    }

}