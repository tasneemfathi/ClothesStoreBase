package com.stores.clothes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        //    val permissionUtil by permissionUtil()
//        permissionUtil.askNotificationPermission()
//        NotifierManager.onCreateOrOnNewIntent(intent)
        installSplashScreen()
        setContent {
            App()
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
       // NotifierManager.onCreateOrOnNewIntent(intent)
    }
}
