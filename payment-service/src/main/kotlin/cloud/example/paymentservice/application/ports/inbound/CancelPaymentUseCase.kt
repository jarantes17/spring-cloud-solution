package cloud.example.paymentservice.application.ports.inbound

interface CancelPaymentUseCase {
    fun cancelPayment(paymentId: Int)
}