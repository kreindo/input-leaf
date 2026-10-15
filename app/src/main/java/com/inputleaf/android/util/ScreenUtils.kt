package com.inputleaf.android.util

import android.content.Context
import android.graphics.Point
import android.graphics.Rect
import android.os.Build
import android.view.WindowManager

object ScreenUtils {
    /**
     * Returns the full screen bounds in pixels across Android versions.
     * Uses [WindowManager.getCurrentWindowMetrics] on Android 11+ (API 30+),
     * and falls back to [android.view.Display.getRealSize] / [android.view.Display.getSize]
     * on older Android versions (API 26-29) where [WindowManager.getCurrentWindowMetrics] does not exist.
     */
    @Suppress("DEPRECATION")
    fun getScreenBounds(context: Context): Rect {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as? WindowManager
            ?: return Rect(0, 0, 0, 0)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            wm.currentWindowMetrics.bounds
        } else {
            val size = Point()
            val display = wm.defaultDisplay
            if (display != null) {
                try {
                    display.getRealSize(size)
                } catch (_: Throwable) {
                    display.getSize(size)
                }
            }
            Rect(0, 0, size.x, size.y)
        }
    }
}
