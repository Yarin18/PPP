package com.yarin.marketingapp

data class Message(
    val contactName: String,
    val contactNumber: String,
    val myDisplayName: String,
    val includeJunior: Boolean,
    val jobTitle: String?,
    val immediateStart: Boolean,
    val startDate: String?
) : java.io.Serializable {

    fun getFullJobDescription() : String {
        return if (includeJunior) {
            "a Junior $jobTitle"
        } else "an $jobTitle"
    }

    fun getAvailability() = if (immediateStart) "immediatly" else "from $startDate"


}