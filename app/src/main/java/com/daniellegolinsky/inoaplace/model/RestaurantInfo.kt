package com.daniellegolinsky.inoaplace.model

import java.io.Serializable

class RestaurantInfo() : Serializable {

    /**
     * One line from JSON:
     *      (Note, each line is a separate JSON object. It's not an array of objects.)
     *          To test this without fixing the "API" response client-side,
     *              I re-uploaded to my own GitHub without content changes,
     *              just updated it to be a json array of json objects.
     * {"address": {"building": "1007", "coord": [-73.856077, 40.848447], "street": "Morris Park Ave", "zipcode": "10462"},
     * "borough": "Bronx",
     * "cuisine": "Bakery",
     * "grades": [{"date": {"$date": 1393804800000}, "grade": "A", "score": 2}, {"date": {"$date": 1378857600000}, "grade": "A", "score": 6} (...)
     * "name": "Morris Park Bake Shop",
     * "restaurant_id": "30075445"}
     */

    var name: String = ""
    var borough: String = ""
    private var grades: List<HealthGrade> = listOf()
    var mostRecentHealthScore: String = ""

    fun getLatestGrade(): String {
        if (mostRecentHealthScore.isBlank()) {
            var bestScoreDate: Long = 0
            var bestScoreValue: Int = 1000
            for (healthScore in grades) {
                if (healthScore.date > bestScoreDate) {
                    bestScoreDate = healthScore.date
                    bestScoreValue = healthScore.score
                }
            }
            return when {
                bestScoreValue <= 12 -> "A"
                bestScoreValue <= 27 -> "B"
                bestScoreValue <= 98 -> "C"
                else -> "Z"
            }
        }
        else {
            return mostRecentHealthScore
        }
    }
}