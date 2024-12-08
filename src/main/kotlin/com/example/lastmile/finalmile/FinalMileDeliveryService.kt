package com.example.lastmile.finalmile

import org.springframework.stereotype.Service

@Service
class FinalMileDeliveryService(private val deliveryRepository: DeliveryRepository) {

    fun complete(deliveryId: Long) {
        val delivery = deliveryRepository.findById(deliveryId)
        delivery.complete()
        deliveryRepository.save(delivery)
    }
}