package com.example.lastmile.finalmile

class Delivery {

    val id: Long
    var status: DeliveryStatus

    constructor(id: Long, status: DeliveryStatus) {
        this.id = id
        this.status = status
    }

    fun complete() {
        status = DeliveryStatus.DELIVERED
    }

}