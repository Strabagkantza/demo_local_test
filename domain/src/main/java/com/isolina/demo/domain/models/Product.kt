package com.isolina.demo.domain.models

import java.text.SimpleDateFormat
import java.util.Date

data class Product(
    val id: String,
    val name: String,
    val details: String? = "",
    val date_unix: Long,
    val date_precision: String,
    val flight_number: Int,
    val success: Boolean,
    val links: Links
): java.io.Serializable {
    fun getImageSmall(): String = links.patch.small ?: ""

    fun getImageLarge(): String = links.patch.large ?: ""

    fun getDate(): String {
        val date = Date(date_unix)
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return formatter.format(date)
    }
}
