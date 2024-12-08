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