package com.decorator.text.textdecor.utils

import android.content.Context
import android.graphics.Typeface

import java.util.HashMap

/**
 * Adapted from github.com/romannurik/muzei/
 *
 *
 * Also see https://code.google.com/p/android/issues/detail?id=9904
 */
internal object FontUtil {

    private val sTypefaceCache = HashMap<String, Typeface>()

    operator fun get(context: Context, font: String): Typeface {
        synchronized(sTypefaceCache) {
            if (!sTypefaceCache.containsKey(font)) {
                val tf = Typeface.createFromAsset(context.applicationContext.assets, font)
                sTypefaceCache.put(font, tf)
            }
            return sTypefaceCache[font]!!
        }
    }
}