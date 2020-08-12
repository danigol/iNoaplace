package com.daniellegolinsky.inoaplace.model

import java.io.Serializable

class RestaurantInfo() : Serializable {

    var borough: String = ""

    // "grades": [{"date": {"$date": 1393804800000}, "grade": "A", "score": 2}, {"date": {"$date": 1378857600000}, "grade": "A", "score": 6}, {"date": {"$date": 1358985600000}, "grade": "A", "score": 10}, {"date": {"$date": 1322006400000}, "grade": "A", "score": 9}, {"date": {"$date": 1299715200000}, "grade": "B", "score": 14}],
    var grades: String = ""
}