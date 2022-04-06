package cloud.example.orderservice.adapters.outbound.persistence.repositories

import cloud.example.orderservice.adapters.outbound.persistence.entities.OrderEntity
import cloud.example.orderservice.adapters.outbound.persistence.repositories.jpa.OrderJpaRepository
import cloud.example.orderservice.application.domain.Order
import cloud.example.orderservice.application.ports.outbound.OrderRepositoryPort
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component("orderRepository")
class OrderRepository : OrderRepositoryPort {

    @Autowired
    lateinit var orderJpaRepositoryPort: OrderJpaRepository

    @Autowired
    lateinit var modelMapper: ModelMapper

    override fun save(order: Order): Order {
        val savedOrder = orderJpaRepositoryPort.save(modelMapper.map(order, OrderEntity::class.java))
        return modelMapper.map(savedOrder, Order::class.java)
    }
}