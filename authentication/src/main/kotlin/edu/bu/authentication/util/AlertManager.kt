package edu.bu.authentication.util

import android.app.Application
import android.widget.Toast
import javax.inject.Inject

interface AlertManager {
    fun alert(message: String)
}

class ToastAlertManager @Inject constructor(
    private val application: Application
) : AlertManager {

    override fun alert(message: String) {
        Toast.makeText(application, message, Toast.LENGTH_SHORT).show()
    }
}