package com.decorator.text.textdecor

import android.content.Context
import android.text.SpannableString
import android.util.AttributeSet
import android.widget.TextView

import java.util.ArrayList

class PrettyText : TextView {

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    }

    fun setText(vararg strings: Any) {
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
}
