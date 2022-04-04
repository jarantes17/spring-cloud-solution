package cloud.example.orderservice.adapters.configuration

import cloud.example.orderservice.application.services.OrderService
import org.modelmapper.ModelMapper
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class BeanConfiguration {

    @Bean
    fun modelMapper(): ModelMapper = ModelMapper()

    @Bean
    @LoadBalanced
    fun restTemplate(): RestTemplate? {
        return RestTemplate()
    }

    @Bean
    fun orderService(): OrderService = OrderService()

}