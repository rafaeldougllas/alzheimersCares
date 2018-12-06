package com.rafaelbarreto.alzheimerscares.model

data class PersonInfo(
    val name: String,
    val id: String,
    val image_id:Int,
    val health_card: String?,
    val alergies:String?
)

