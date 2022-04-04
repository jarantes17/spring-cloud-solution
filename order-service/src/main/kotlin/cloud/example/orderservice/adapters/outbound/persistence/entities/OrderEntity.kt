package cloud.example.orderservice.adapters.outbound.persistence.entities

import org.hibernate.Hibernate
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "ORDER_TB")
data class OrderEntity(
    @Id
    val id: Int,
    val name: String,
    val quantity: Int,
    val price: Double
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as OrderEntity

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}