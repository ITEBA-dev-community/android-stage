package com.example.elibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.material.bottomnavigation.BottomNavigationView

class peminjaman : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peminjaman)

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
                    finish()
                }
            }
            true
        }

        val webview5 = findViewById<WebView>(R.id.webviewpeminjaman)
        webview5.loadUrl("https://ikariegroup.co.id/peminjaman.php")
        webview5.webViewClient = WebViewClient()
        webview5.settings.javaScriptEnabled = true


    }
}