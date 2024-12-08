package com.example.lastmile.notification

import org.springframework.stereotype.Component

@Component
class NotificationSystemLogClient : NotificationClient {
    override fun send(deliveryId: Long) {
        println("send notification, deliveryId: [$deliveryId]")
    }
}