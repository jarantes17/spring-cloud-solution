package cloud.example.orderservice.application.domain

class Order(
    val id: Int,
    val name: String,
    val quantity: Int,
    val price: Double
)