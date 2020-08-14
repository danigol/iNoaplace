package com.daniellegolinsky.inoaplace.model

import org.json.JSONObject
import java.io.Serializable

class HealthGrade : Serializable {
    lateinit var date: JSONObject
    var score: Int = -1
    var grade: String = "Z" // PENDING
}