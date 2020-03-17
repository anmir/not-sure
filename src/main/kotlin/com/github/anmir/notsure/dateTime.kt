package com.github.anmir.notsure

import java.time.Duration
import java.time.Period

fun main() {
    interval()

}

/**
 *
 *  ISO 8601 Durations are expressed using the following format, where (n) is replaced by the value for each of the date and time elements that follow the (n):

P(n)Y(n)M(n)DT(n)H(n)M(n)S

Where:

P is the duration designator (referred to as "period"), and is always placed at the beginning of the duration.
Y is the year designator that follows the value for the number of years.
M is the month designator that follows the value for the number of months.
W is the week designator that follows the value for the number of weeks.
D is the day designator that follows the value for the number of days.
T is the time designator that precedes the time components.
H is the hour designator that follows the value for the number of hours.
M is the minute designator that follows the value for the number of minutes.
S is the second designator that follows the value for the number of seconds.
 * */
fun interval() {
    val oneYear = "P1Y"
    val oneYearAsPeriod = Period.parse(oneYear)
    println(oneYearAsPeriod)
    val oneYearAsDuration = Duration.parse(oneYear)//produces error

}