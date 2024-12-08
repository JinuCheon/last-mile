package com.example.lastmile.finalmile

import io.kotest.core.spec.style.StringSpec

class FinalMileDeliveryServiceTest : StringSpec({

    val deliveryRepository = DeliveryMemoryRepository()
    val finalMileDeliveryService = FinalMileDeliveryService(deliveryRepository)

    "고객의 집 앞에 배송이 완료된 경우, Delivery 의 status 를 배송완료 상태로 변경한다." {
        val deliveryId = 1L
        deliveryRepository.save(Delivery(deliveryId, DeliveryStatus.PICKED_UP))

        finalMileDeliveryService.complete(deliveryId)

        deliveryRepository.findById(deliveryId)
    }
}) {
    class Delivery {

        val id: Long
        var status: DeliveryStatus

        constructor(id: Long, status: DeliveryStatus) {
            this.id = id
            this.status = status
        }

        fun complete() {
            status = DeliveryStatus.DELIVERED
        }

    }

    enum class DeliveryStatus {
        PICKED_UP,
        DELIVERED
    }

    class FinalMileDeliveryService(private val deliveryRepository: DeliveryRepository) {

        fun complete(deliveryId: Long) {
            val delivery = deliveryRepository.findById(deliveryId)
            delivery.complete()
            deliveryRepository.save(delivery)
        }
    }

    interface DeliveryRepository {
        fun findById(deliveryId: Long): Delivery
        fun save(delivery: Delivery)
    }

    class DeliveryMemoryRepository : DeliveryRepository {

        private val deliveries = mutableMapOf<Long, Delivery>()

        override fun findById(deliveryId: Long): Delivery {
            return deliveries[deliveryId] ?: throw IllegalArgumentException("Delivery not found")
        }

        override fun save(delivery: Delivery) {
            deliveries[delivery.id] = delivery
        }
    }
}