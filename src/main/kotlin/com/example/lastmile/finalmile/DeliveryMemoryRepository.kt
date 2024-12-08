package com.example.lastmile.finalmile

import org.springframework.stereotype.Repository

@Repository
class DeliveryMemoryRepository : DeliveryRepository {

    private val deliveries = mutableMapOf<Long, Delivery>()

    override fun findById(deliveryId: Long): Delivery {
        return deliveries[deliveryId] ?: throw IllegalArgumentException("Delivery not found")
    }

    override fun save(delivery: Delivery) {
        deliveries[delivery.id] = delivery
    }
}