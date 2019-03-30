package io.github.ilaborie.loops.samples


fun main() {

    data class Result(val n: Int, val result: String, val rec: String, val seq: String)

    generateSequence(1) { i -> i + 1 }
        .map { Result(it, withFor(it), withRecursion(it), withSequence(it)) }
        .takeWhile { it.result != "FUN" }
        .map { (n, s, rec, seq) ->
            val success = (s == rec) && (s == seq)
            "${if (success) "✅" else "‼️"} column($n) = $s  ($rec) ($seq)"
        }
        .forEach { println(it) }
}

fun withFor(n: Int): String {
    var chars = ""
    var current = n

    while (true) {
        current--
        chars = ('A'.toInt() + current % 26).toChar() + chars
        if (current < 26) break
        current /= 26
    }
    return chars
}

fun withRecursion(n: Int): String {
    tailrec fun aux(n: Int, acc: String): String {
        val current = n - 1
        val rest = current % 26
        val result = ('A'.toInt() + rest).toChar() + acc
        return if (current < 26) result
        else aux(current / 26, result)
    }
    return aux(n, "")
}

fun withSequence(n: Int): String =
    generateSequence<Pair<Int?, String>>(n to "") { (n, acc) ->
        if (n == null) null
        else {
            val current = n - 1
            val result = ('A'.toInt() + current % 26).toChar() + acc

            if (current < 26) null to result
            else (current / 26) to result
        }
    }.last().second