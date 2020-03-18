package com.github.anmir.notsure

import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.Period

fun main() {
    localDateTimeOperations()
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

fun localDateTimeOperations() {
    val oneDay = Duration.ofDays(1)
    val oneYear = Period.ofYears(1)

    LocalDateTime.now().plus(oneDay)
    LocalDateTime.now().plus(oneYear)

    Instant.now().plus(oneDay) //OK
    Instant.now().plus(oneYear) // produces java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Years

}
/**
 * особенности работы с датами

jackson:
objectMapper.timeZone  - это и есть contextTimeZone
ADJUST_DATES_TO_CONTEXT_TIME_ZONE - влияет только для ZonedDateTime, OffsetDateTime
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Europe/Moscow") - параметр timezone - работает только в паре с pattern

PostgreSQL JDBC driver по умолчанию устанавливает timeZone в соответствие с JVM;
db -> java Instant имеет смысл при хранении timestamp without timezone
Duration & Period - представляют Interval  P(n)Y(n)M(n)DT(n)H(n)M(n)S. Но! Period работает с левой частью P(n)Y(n)M(n)D, а Duration c правой PT(n)H(n)M(n)S. Они реализуют общий интерфейс TemporalAmount. *При работе с jackson есть формат преобразуется в наиболее подходящий: т.е. задав PT3600M десериализация и сериализация приведут к PT1H.
Instant- работает с duration & Period. НО! если Period>day, то runtime ошибка
LocalDateTime - удобен для операций с датами. Можно безопасно использовать при условии, что timeZone JVM - utc
ZonedDateTime - имеет смысл если хранить в БД timestamp with timezone
OffsetDateTime - удобен для коммуникации между сервисами, т.к. всегда хранит смещение. По сути - репрезентация формата +02:00
ZoneId for Instant <-> LocalDateTime conversion

При работе с операциями над датами важно писать тесты на короткие интервалы времени (минуты, секунды).
 *
 *
 *
 * */
