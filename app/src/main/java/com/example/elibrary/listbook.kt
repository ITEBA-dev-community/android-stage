package com.example.elibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.material.bottomnavigation.BottomNavigationView

class listbook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listbook)

        val bottomnavigation = findViewById<BottomNavigationView>(R.id.botnavigation)
        bottomnavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(0, 0);
                    finish()
                }

                R.id.ic_listbook -> {

                    overridePendingTransition(0, 0);

                }
                R.id.ic_peminjaman -> {
                    startActivity(Intent(this, peminjaman::class.java))
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

        val webview4 = findViewById<WebView>(R.id.webviewlistbook)
        webview4.loadUrl("https://ikariegroup.co.id/listbook.php")
        webview4.webViewClient = WebViewClient()
        webview4.settings.javaScriptEnabled = true

    }
}