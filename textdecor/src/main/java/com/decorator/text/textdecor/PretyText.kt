package com.decorator.text.textdecor

import android.text.SpannableString
import android.widget.TextView
import java.util.*

fun TextView.setPrittytext(vararg strings: Any) {
    var textDecor: TextDecor
    val spannableString: SpannableString
    val stringBuilder = StringBuilder()
    val decorationDates = ArrayList<DecorationData>()

    var index = 0
    var tempStr: String

    for (string in strings) {
        if (string is TextDecor) {
            textDecor = string
            tempStr = textDecor.getText()
            stringBuilder.append(tempStr)
            decorationDates.add(DecorationData(intArrayOf(index, index + tempStr.length), textDecor))
            index += tempStr.length
        } else {
            stringBuilder.append(string as String)
            index += string.length
        }
    }

    spannableString = SpannableString(stringBuilder)

    for (decorationData in decorationDates) {
        decorationData.textDecor!!.decorateText(spannableString, decorationData.coordinates[0], decorationData.coordinates[1])
    }
    text = spannableString
}

fun String.addDecor(dec:TextD):TextD{
    return dec.withText(this)
}