package com.example.callapi.data

data class FullData(val results: List<User>)
data class Id(val name: String, val value: String)
data class DoB(val date: String, val age: Int)
data class Name(val title: String, val first: String, val last: String)
data class Picture(val large: String, val medium: String, val thumbnail: String)
data class Street(val number: Int, val name: String)
data class Timezone(val offset: String, val description: String)

data class User(
    val id: Id,
    val dob: DoB,
    val name: Name,
    val location: Location,
    val picture: Picture,
    val phone: String,
    val nat: String,
    val email: String,
    val gender: String,
)
data class Location(
    val street: Street,
    val city: String,
    val country: String,
    val postcode: String,
    val timezone: Timezone
)




