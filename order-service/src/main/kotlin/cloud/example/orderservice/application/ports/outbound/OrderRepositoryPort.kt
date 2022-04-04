package cloud.example.orderservice.application.ports.outbound

import cloud.example.orderservice.application.domain.Order
import org.springframework.stereotype.Repository

@Repository
interface OrderRepositoryPort {
    fun save(order: Order) : Order
}