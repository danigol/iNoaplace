package com.daniellegolinsky.inoaplace.model

import android.util.Log
import java.io.Serializable

class RestaurantInfo() : Serializable {

    /**
     * One line from JSON:
     * {"address": {"building": "1007", "coord": [-73.856077, 40.848447], "street": "Morris Park Ave", "zipcode": "10462"},
     * "borough": "Bronx",
     * "cuisine": "Bakery",
     * "grades": [
     *      {"date": {"epoch_date": 1393804800000}, "grade": "A", "score": 2},
     *      {"date": {"epoch_date": 1378857600000}, "grade": "A", "score": 6},
     *      {"date": {"epoch_date": 1358985600000}, "grade": "A", "score": 10},
     *      {"date": {"epoch_date": 1322006400000}, "grade": "A", "score": 9},
     *      {"date": {"epoch_date": 1299715200000}, "grade": "B", "score": 14}
     *      ],
     *  "name": "Morris Park Bake Shop",
     *  "restaurant_id": "30075445"},
     */

    var name: String = ""
    var borough: String = ""
    private var grades: List<HealthGrade> = listOf()
    var mostRecentHealthScore: String = ""

    fun getLatestGrade(): String {
        if (mostRecentHealthScore.isBlank()) {
            var latestHealthGrade = HealthGrade()

            if (grades.isNotEmpty()) {
                latestHealthGrade = grades[0]
            }
            mostRecentHealthScore = latestHealthGrade.grade
        }
        return mostRecentHealthScore
    }
}