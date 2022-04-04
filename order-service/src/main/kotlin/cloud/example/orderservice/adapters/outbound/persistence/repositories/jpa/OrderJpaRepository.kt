package cloud.example.orderservice.adapters.outbound.persistence.repositories.jpa

import cloud.example.orderservice.adapters.outbound.persistence.entities.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderJpaRepository : JpaRepository<OrderEntity, Int> {
}