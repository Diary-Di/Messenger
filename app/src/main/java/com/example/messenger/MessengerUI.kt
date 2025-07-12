package com.example.messenger

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppUI(onSend: (String, String) -> Unit, onGoToProfil: () -> Unit) {
    var message by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text("Messenger") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = message,
                onValueChange = { message = it },
                label = { Text("Message") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    if (message.isNotBlank()) {
                        onSend("Moi", message)
                        message = ""
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Envoyer")
            }
        }
    }

    TopAppBar(
        title = { Text("Messenger") },
        actions = {
            IconButton(onClick = { onGoToProfil() }) {
                Icon(Icons.Default.AccountCircle, contentDescription = "Profil")
            }
        }
    )
}
