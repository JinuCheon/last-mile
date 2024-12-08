package com.example.lastmile.notification

class NotificationSystemLogClient : NotificationClient {
    override fun send(deliveryId: Long) {
        println("send notification, deliveryId: [$deliveryId]")
    }
}