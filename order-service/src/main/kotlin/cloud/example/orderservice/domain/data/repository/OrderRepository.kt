package cloud.example.orderservice.domain.data.repository

import cloud.example.orderservice.domain.data.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Int> {
}