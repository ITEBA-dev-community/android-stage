package com.example.elibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.material.bottomnavigation.BottomNavigationView

class account : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        val bottomnavigation = findViewById<BottomNavigationView>(R.id.botnavigation)
        bottomnavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(0, 0);
                    finish()
                }

                R.id.ic_listbook -> {
                    startActivity(Intent(this, listbook::class.java))
                    overridePendingTransition(0, 0);
                    finish()
                }
                R.id.ic_peminjaman -> {
                    startActivity(Intent(this, peminjaman::class.java))
                    overridePendingTransition(0, 0);
                    finish()

                }
                R.id.ic_account -> {

                    overridePendingTransition(0, 0);
                }
                R.id.ic_chat -> {
                    startActivity(Intent(this, chat::class.java))
                    overridePendingTransition(0, 0);
                    finish()
                }
            }
            true
        }

        val webview2 = findViewById<WebView>(R.id.webviewaccount)
        webview2.loadUrl("https://ikariegroup.co.id/account.php")
        webview2.webViewClient = WebViewClient()
        webview2.settings.javaScriptEnabled = true



    }
}