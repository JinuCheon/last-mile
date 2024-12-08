package com.example.lastmile.notification

interface NotificationClient {
    fun send(deliveryId: Long)
}