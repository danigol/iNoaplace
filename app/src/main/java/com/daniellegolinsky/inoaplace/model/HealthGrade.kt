package com.daniellegolinsky.inoaplace.model

import java.io.Serializable

class HealthGrade : Serializable {
    var date: Long = -1
    var score: Int = -1
    var grade: String = "Z" // PENDING
}