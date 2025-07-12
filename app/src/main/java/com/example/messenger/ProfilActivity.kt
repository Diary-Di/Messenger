package com.example.messenger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.messenger.ui.theme.MessengerTheme

class ProfilActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessengerTheme {
                ProfilUI(
                    nom = "Jean Dupont",
                    email = "jean.dupont@email.com",
                    motDePasse = "password123"
                )
            }
        }
    }
}
