package com.github.olivernybroe.wingidea.ide.services

import com.intellij.util.messages.Topic

interface WingConsoleListener {
    companion object {
        val WING_CONSOLE_TOPIC = Topic.create(
            "Wing Console Listener",
            WingConsoleListener::class.java
        )
    }

    suspend fun onStateChanged()

    suspend fun onResourceFocusChanged(path: String)
}

