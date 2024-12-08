package com.example.lastmile.finalmile

interface DeliveryRepository {
    fun findById(deliveryId: Long): Delivery
    fun save(delivery: Delivery)
}