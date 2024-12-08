package com.example.lastmile.notification

import org.junit.jupiter.api.Test
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.bean.override.mockito.MockitoBean

@SpringBootTest
class NotificationServiceTest {

    @Autowired
    private lateinit var notificationService: NotificationService

    @MockitoBean
    private lateinit var notificationClient: NotificationClient

    @Test
    fun `배송완료 이벤트가 발생하면 push notification 을 전송한다`() {
        // given
        val deliveryId = 1L

        // when
        notificationService.sendDeliveryCompleteNotification(deliveryId)

        // then
        verify(notificationClient, times(1)).send(deliveryId)
    }
}
