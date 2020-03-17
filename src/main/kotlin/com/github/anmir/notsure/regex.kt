package com.github.anmir.notsure

import java.util.regex.Pattern

fun main() {
//    findSpaces()
    findWords()

}
private fun findWords() {
    var regex1 = Regex(".*[A-Z]+")
    println("asdA".matches(regex1))
    println("sdalsddkfj ".matches(regex1))
    println("sdaldk fj ".matches(regex1))
    println(" sdaldk fj ".matches(regex1))
}

private fun findSpaces() {
    var regex1 = Regex(".*\\s+")
    println("sdaldkfj".matches(regex1))
    println("sdaldkfj ".matches(regex1))
    println("sdaldk fj ".matches(regex1))
    println(" sdaldk fj ".matches(regex1))
}


/**
 * matches tries to match the expression against the entire string and implicitly add a ^ at the start and $ at the end
 * of your pattern, meaning it will not look for a substring.
 * */
private fun differenceBetweenFindAndMatches() {
    var p = Pattern.compile("\\d\\d\\d")
    var m = p.matcher("a123b")
    println(m.find())
    println(m.matches())

    p = Pattern.compile("^\\d\\d\\d$")
    m = p.matcher("123")
    println(m.find())
    println(m.matches())
}

