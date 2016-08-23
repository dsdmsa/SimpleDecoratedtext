package com.decorator.text.textdecorator

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.decorator.text.textdecor.*

class MainActivity2 : AppCompatActivity() {

    internal var prettyText: PrettyText? = null
    internal var prettyText2: PrettyText? = null
    internal var simpleTxt: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prettyText = findViewById(R.id.textDecor) as PrettyText
        prettyText2 = findViewById(R.id.textDecor2) as PrettyText
        simpleTxt = findViewById(R.id.simpleText) as TextView


        val rbackg = TextDecor.Builder().decorate(TextDecor.UNDERLINE()).decorate(TextDecor.relativeTextSize(30)).decorate(TextDecor.setBackground(Color.RED))//                .decorate(TextDecor.Companion.font(this, "fonts/Roboto-Thin.ttf"))
                .decorate(TextDecor.setTextColor(Color.BLACK)).decorate(TextDecor.BOLD()).build()

        val siz = TextDecor.Builder().build()
        val col = TextDecor.Builder().build()
        val round = TextDecor.Builder().build()
        val round1 = TextDecor.Builder().build()
        val round2 = TextDecor.Builder().build()

        prettyText?.setText(
                round.withText(" round "),
                siz.withText("\nYou pucharse\n"),
                rbackg.withText("Yesterday\n"),
                siz.withText("please show this QR......\n"),
                " simple text ",
                rbackg.withText("\n\nanother"),
                siz.withText(" siz\n"),
                col.withText(" col text \n"))

        prettyText2?.setText(" ",
                round.withText(" round "),
                round1.withText(" round "),
                round2.withText(" round "))

        val td = TextD(TextD.BOLD(), TextD.STRINKE())


        simpleTxt?.setPrittytext(
                "asds".addDecor(td),
                "asd".addDecor(td),
                "asasdasdds".addDecor(td),
                td.withText("asdasd"),
                rbackg.withText("asfasdf"))

    }
}
