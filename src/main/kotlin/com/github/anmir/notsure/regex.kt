package com.github.anmir.notsure

fun main() {
    var regex1 = Regex(".*\\s+$")
    println("sdaldkfj".matches(regex1))
    println("sdaldkfj ".matches(regex1))
    println("sdaldk fj ".matches(regex1))
    println(" sdaldk fj ".matches(regex1))
}

