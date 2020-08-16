package com.daniellegolinsky.inoaplace.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class HealthGrade : Serializable {
    @SerializedName("\$date")
    var date: Long = 0
    var score: Int = -1
    var grade: String = "Z" // PENDING
}