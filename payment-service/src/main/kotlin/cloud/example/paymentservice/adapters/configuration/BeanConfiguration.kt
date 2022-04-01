package cloud.example.paymentservice.adapters.configuration

import cloud.example.paymentservice.adapters.outbound.persistence.repositories.PaymentRepository
import cloud.example.paymentservice.application.ports.outbound.PaymentRepositoryPort
import cloud.example.paymentservice.application.services.PaymentService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {

    @Bean
    fun paymentRepository(): PaymentRepositoryPort {
        return PaymentRepository()
    }

    @Bean
    fun paymentService(): PaymentService {
        return PaymentService()
    }

}