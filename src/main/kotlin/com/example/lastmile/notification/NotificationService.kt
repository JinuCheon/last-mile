package com.example.lastmile.notification

class NotificationService(private val notificationClient: NotificationClient) {
    fun sendDeliveryCompleteNotification(deliveryId: Long) {
        notificationClient.send(deliveryId)
    }
}