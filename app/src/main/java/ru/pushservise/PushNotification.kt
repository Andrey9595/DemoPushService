package ru.pushservise

import android.content.Intent
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class PushNotification : FirebaseMessagingService() {
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        val intent = Intent(INTENT_FILTER)
        message.data.forEach { entry ->
            intent.putExtra(entry.key, entry.value)
        }
        sendBroadcast(intent)
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)

    }

    companion object {
        const val INTENT_FILTER = "PUSH"
    }
}