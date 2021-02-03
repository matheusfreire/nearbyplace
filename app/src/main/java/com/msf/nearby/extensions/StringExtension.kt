package com.msf.nearby.extensions

import java.text.SimpleDateFormat
import java.util.*

val localeBr = Locale("pt", "BR")

fun String.toBRPatternDate() : String {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'", localeBr)
    val date = formatter.parse(this)
    val formatBr = SimpleDateFormat("dd/mm/yyyy HH:mm:ss", localeBr)
    return formatBr.format(date)
}