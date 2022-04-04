package cloud.example.serviceregistry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class ServiceRegistryApplication

fun main(args: Array<String>) {
    runApplication<ServiceRegistryApplication>(*args)
}
