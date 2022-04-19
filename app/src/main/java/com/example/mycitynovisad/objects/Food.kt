package com.example.mycitynovisad.objects

class Food(
    foodImageId: Int,
    foodName: String,
    foodDescription: String,
    foodAddress: String,
    foodTransportation: String,
    foodPhone: String?,
    foodWeb: String?,
    foodHours: String,
    foodFee: String
) {
    var foodImageId: Int = foodImageId
        private set
    var foodName: String = foodName
        private set
    var foodDescription: String = foodDescription
        private set
    var foodAddress: String = foodAddress
        private set
    var foodTransportation: String = foodTransportation
        private set
    var foodPhone: String? = foodPhone
        private set
    var foodWeb: String? = foodWeb
        private set
    var foodHours: String = foodHours
        private set
    var foodFee: String = foodFee
        private set

}