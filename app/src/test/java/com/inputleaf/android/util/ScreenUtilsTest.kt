package com.inputleaf.android.util

import android.app.Application
import android.os.Build
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
class ScreenUtilsTest {

    @Test
    @Config(sdk = [Build.VERSION_CODES.UPSIDE_DOWN_CAKE])
    fun `getScreenBounds on API 34 returns valid bounds`() {
        val context = ApplicationProvider.getApplicationContext<Application>()
        val bounds = ScreenUtils.getScreenBounds(context)
        assertThat(bounds.width()).isGreaterThan(0)
        assertThat(bounds.height()).isGreaterThan(0)
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.Q])
    fun `getScreenBounds on API 29 succeeds without NoSuchMethodError`() {
        val context = ApplicationProvider.getApplicationContext<Application>()
        val bounds = ScreenUtils.getScreenBounds(context)
        assertThat(bounds.width()).isGreaterThan(0)
        assertThat(bounds.height()).isGreaterThan(0)
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.O])
    fun `getScreenBounds on API 26 succeeds without NoSuchMethodError`() {
        val context = ApplicationProvider.getApplicationContext<Application>()
        val bounds = ScreenUtils.getScreenBounds(context)
        assertThat(bounds.width()).isGreaterThan(0)
        assertThat(bounds.height()).isGreaterThan(0)
    }
}
