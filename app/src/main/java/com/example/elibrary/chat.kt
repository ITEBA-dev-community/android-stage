package com.example.elibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.material.bottomnavigation.BottomNavigationView

class chat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

            val bottomnavigation = findViewById<BottomNavigationView>(R.id.botnavigation)
            bottomnavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(0, 0);
                    finish()
                }

                R.id.ic_account -> {
                    startActivity(Intent(this, account::class.java))
                    overridePendingTransition(0, 0);
                    finish()
                }
                R.id.ic_chat -> {
                    startActivity(Intent(this, chat::class.java))
                    overridePendingTransition(0, 0);

                }
            }
            true
        }

        val webview3 = findViewById<WebView>(R.id.webviewchat)
        webview3.loadUrl("https://ikariegroup.co.id/chat.php")
        webview3.webViewClient = WebViewClient()
        webview3.settings.javaScriptEnabled = true

    }
}