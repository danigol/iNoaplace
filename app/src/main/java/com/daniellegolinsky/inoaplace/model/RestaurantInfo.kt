package com.daniellegolinsky.inoaplace.model

import java.io.Serializable

class RestaurantInfo() : Serializable {

    var name: String = ""
    var borough: String = ""
    // "grades": [{"date": {"$date": 1393804800000}, "grade": "A", "score": 2}, {"date": {"$date": 1378857600000}, "grade": "A", "score": 6}, {"date": {"$date": 1358985600000}, "grade": "A", "score": 10}, {"date": {"$date": 1322006400000}, "grade": "A", "score": 9}, {"date": {"$date": 1299715200000}, "grade": "B", "score": 14}],
    var grades: String = ""

    // TODO Implement logic and parsing
    fun getLatestGrade(): String {
        return "A"
    }
    // TODO Implement logic and parsing
    fun getLatestGradeValue(): Int {
        return 0
    }
}