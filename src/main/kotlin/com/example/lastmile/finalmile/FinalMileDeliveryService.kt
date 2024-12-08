package com.example.lastmile.finalmile

class FinalMileDeliveryService(private val deliveryRepository: DeliveryRepository) {

    fun complete(deliveryId: Long) {
        val delivery = deliveryRepository.findById(deliveryId)
        delivery.complete()
        deliveryRepository.save(delivery)
    }
}