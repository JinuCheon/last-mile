package com.example.lastmile.notification

import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class NotificationServiceTest {

    @Test
    fun `배송완료 이벤트가 발생하면 push notification 을 전송한다`() {
        // given
        val notificationClient = mock<NotificationClient>()
        val notificationService = NotificationService(notificationClient)
        val deliveryId = 1L

        // when
        notificationService.sendDeliveryCompleteNotification(deliveryId)

        // then
        verify(notificationClient, times(1)).send(deliveryId)
    }
}

class NotificationService(private val notificationClient: NotificationClient) {
    fun sendDeliveryCompleteNotification(deliveryId: Long) {
        notificationClient.send(deliveryId)
    }
}

class NotificationClient {
    fun send(deliveryId: Long) {
        println("send notification, deliveryId: [$deliveryId]")
    }
}
