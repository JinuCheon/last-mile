package com.example.lastmile.finalmile

import io.kotest.core.spec.style.StringSpec

class FinalMileDeliveryServiceTest : StringSpec({

    val deliveryRepository = DeliveryMemoryRepository()
    val finalMileDeliveryService = FinalMileDeliveryService(deliveryRepository)

    "고객의 집 앞에 배송이 완료된 경우, Delivery 의 status 를 배송완료 상태로 변경한다." {
        val deliveryId = 1L
        deliveryRepository.save(Delivery(deliveryId, DeliveryStatus.PICKED_UP))

        finalMileDeliveryService.complete(deliveryId)

        deliveryRepository.findById(deliveryId)
    }
})