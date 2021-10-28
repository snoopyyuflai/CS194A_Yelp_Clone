package edu.stanford.yuflai.assignment3

import com.google.gson.annotations.SerializedName

data class YelpSearchResult (
    @SerializedName("total") val total: Int,
    @SerializedName("businesses") val restaurants: List<YelpRestaurant>
)

data class YelpRestaurant(
    val name: String,
    val rating: Double,
    val price: String,
    @SerializedName("is_closed") val is_closed: Boolean,
    @SerializedName("display_phone") val display_phone: String,
    @SerializedName("review_count") val numReviews: Int,
    @SerializedName("distance") val distanceInMeters: Double,
    @SerializedName("image_url") val imageUrl: String,
    val categories: List<YelpCategory>,
    val location: YelpLocation
    ){
    fun displayDistance(): String {
        val milesPerMeter = 0.000621371
        val distanceInmiles = "%.2f".format(distanceInMeters*milesPerMeter)
        return "$distanceInmiles mi"
    }
}

data class YelpCategory(
    val title: String
)

data class YelpLocation(
    @SerializedName("address1") val address: String
)