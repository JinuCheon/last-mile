package com.example.lastmile.finalmile

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class FinalMileDeliveryServiceTest : StringSpec({

    val repository = DeliveryMemoryRepository()
    val sut = FinalMileDeliveryService(repository)

    "고객의 집 앞에 배송이 완료된 경우, Delivery 의 status 를 배송완료 상태로 변경한다." {
        val deliveryId = createDelivery(repository)

        sut.complete(deliveryId)

        val delivery = repository.findById(deliveryId)
        delivery.status shouldBe DeliveryStatus.DELIVERED
    }
})

private fun createDelivery(repository: DeliveryMemoryRepository): Long {
    val deliveryId = 1L
    repository.save(Delivery(deliveryId, DeliveryStatus.PICKED_UP))
    return deliveryId
}