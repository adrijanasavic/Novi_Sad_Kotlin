package com.example.mycitynovisad.objects

class Attraction {
    var attractionImageId: Int
        private set
    var attractionName: String
        private set
    var attractionShortDs: String? = null
        private set
    var attractionDescription: String
        private set
    var attractionAddress: String
        private set
    var attractionTransportation: String
        private set
    var attractionPhone: String? = null
        private set
    var attractionWeb: String? = null
        private set
    var attractionHours: String
        private set
    var attractionFee: String? = null
        private set

    constructor(
        attractionImageId: Int, attractionName: String, attractionShortDs: String?,
        attractionDescription: String, attractionAddress: String,
        attractionTransportation: String, attractionPhone: String?,
        attractionWeb: String?, attractionHours: String, attractionFee: String?
    ) {
        this.attractionImageId = attractionImageId
        this.attractionName = attractionName
        this.attractionShortDs = attractionShortDs
        this.attractionDescription = attractionDescription
        this.attractionAddress = attractionAddress
        this.attractionTransportation = attractionTransportation
        this.attractionPhone = attractionPhone
        this.attractionWeb = attractionWeb
        this.attractionHours = attractionHours
        this.attractionFee = attractionFee
    }

    constructor(
        attractionImageId: Int, attractionName: String, attractionDescription: String,
        attractionAddress: String, attractionTransportation: String, attractionHours: String
    ) {
        this.attractionImageId = attractionImageId
        this.attractionName = attractionName
        this.attractionDescription = attractionDescription
        this.attractionAddress = attractionAddress
        this.attractionTransportation = attractionTransportation
        this.attractionHours = attractionHours
    }
}