package cloud.example.paymentservice.adapters.outbound.persistence.repositories

import cloud.example.paymentservice.adapters.outbound.persistence.entities.PaymentEntity
import cloud.example.paymentservice.adapters.outbound.persistence.repositories.jpa.PaymentJpaRepository
import cloud.example.paymentservice.application.domain.Payment
import cloud.example.paymentservice.application.ports.outbound.PaymentRepositoryPort
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Repository
class PaymentRepository() : PaymentRepositoryPort {

    @Autowired
    lateinit var paymentJpaRepository: PaymentJpaRepository

    @Autowired
    lateinit var modelMapper: ModelMapper

    override fun save(payment: Payment): Payment {
        val paymentSaved = paymentJpaRepository.save(modelMapper.map(payment, PaymentEntity::class.java))
        return modelMapper.map(paymentSaved, Payment::class.java)
    }

    override fun findByOrderId(orderId: Int): Payment {
        val paymentFiltered = paymentJpaRepository.findByOrderId(orderId)
        return modelMapper.map(paymentFiltered, Payment::class.java)
    }

}