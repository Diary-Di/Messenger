package com.example.messenger

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilUI(nom: String, email: String, motDePasse: String) {
    var motDePasseVisible by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Profil Utilisateur") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(20.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Nom
            Text(text = "Nom", style = MaterialTheme.typography.labelLarge)
            OutlinedTextField(
                value = nom,
                onValueChange = {},
                enabled = false,
                modifier = Modifier.fillMaxWidth()
            )

            // Email
            Text(text = "Email", style = MaterialTheme.typography.labelLarge)
            OutlinedTextField(
                value = email,
                onValueChange = {},
                enabled = false,
                modifier = Modifier.fillMaxWidth()
            )

            // Mot de passe
            Text(text = "Mot de passe", style = MaterialTheme.typography.labelLarge)
            OutlinedTextField(
                value = motDePasse,
                onValueChange = {},
                enabled = false,
                visualTransformation = if (motDePasseVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (motDePasseVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility
                    IconButton(onClick = { motDePasseVisible = !motDePasseVisible }) {
                        Icon(imageVector = icon, contentDescription = null)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
