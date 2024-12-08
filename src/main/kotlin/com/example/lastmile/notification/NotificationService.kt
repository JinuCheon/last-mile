package com.example.lastmile.notification

import org.springframework.stereotype.Service

@Service
class NotificationService(private val notificationClient: NotificationClient) {
    fun sendDeliveryCompleteNotification(deliveryId: Long) {
        notificationClient.send(deliveryId)
    }
}