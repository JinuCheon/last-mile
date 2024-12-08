package com.example.lastmile.finalmile

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FinalMileDeliveryServiceTest {

    @Autowired
    private lateinit var repository: DeliveryMemoryRepository

    @Autowired
    private lateinit var sut: FinalMileDeliveryService

    @Test
    fun `고객의 집 앞에 배송이 완료된 경우, Delivery 의 status 를 배송완료 상태로 변경한다`() {
        val deliveryId = createDelivery()

        sut.complete(deliveryId)

        val delivery = repository.findById(deliveryId)
        assertEquals(DeliveryStatus.DELIVERED, delivery.status)
    }

    private fun createDelivery(): Long {
        val deliveryId = 1L
        repository.save(Delivery(deliveryId, DeliveryStatus.PICKED_UP))
        return deliveryId
    }
}