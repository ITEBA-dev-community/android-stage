

package com.example.elibrary

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // ini deprecated sen on nya, bikin force exit

        val bottomnavigation = findViewById<BottomNavigationView>(R.id.botnavigation)
        bottomnavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(0, 0);

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

        val webviewhome = findViewById<WebView>(R.id.webview1)
        webviewhome.loadUrl("https://ikariegroup.co.id/home.php")
        webviewhome.webViewClient = WebViewClient()
        webviewhome.settings.javaScriptEnabled = true



    }



}