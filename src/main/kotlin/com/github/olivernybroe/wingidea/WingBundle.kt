package com.github.olivernybroe.wingidea

import com.intellij.DynamicBundle
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.PropertyKey

@NonNls
const val WING_BUNDLE = "messages.WingBundle"

object WingBundle : DynamicBundle(WING_BUNDLE) {

    @Suppress("SpreadOperator")
    @JvmStatic
    fun message(@PropertyKey(resourceBundle = WING_BUNDLE) key: String, vararg params: Any) =
        getMessage(key, *params)

    @Suppress("SpreadOperator", "unused")
    @JvmStatic
    fun messagePointer(@PropertyKey(resourceBundle = WING_BUNDLE) key: String, vararg params: Any) =
        getLazyMessage(key, *params)
}
