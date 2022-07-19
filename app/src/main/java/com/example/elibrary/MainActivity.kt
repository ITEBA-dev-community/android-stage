

package com.example.elibrary

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.system.exitProcess


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
                    finish()

                }


                R.id.ic_chat -> {
                    startActivity(Intent(this, chat::class.java))
                    overridePendingTransition(0, 0);
                    finish()
                }

                R.id.ejurnal -> {
                    startActivity(Intent(this, ejurnal::class.java))
                    overridePendingTransition(0,0)
                    finish()
                }

                R.id.ic_peminjaman -> {
                    startActivity(Intent(this, peminjaman::class.java))
                    overridePendingTransition(0,0)
                    finish()
                }
            }
            true
        }

        val webviewhome = findViewById<WebView>(R.id.webview1)
        webviewhome.loadUrl("https://ikariegroup.co.id/home.php")
        webviewhome.webViewClient = WebViewClient()
        webviewhome.webChromeClient = WebChromeClient()
        webviewhome.settings.domStorageEnabled = true
        webviewhome.settings.javaScriptEnabled = true
        webviewhome.settings.setPluginState(WebSettings.PluginState.ON);





    }


    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("EXIT")
            setMessage("ingin keluar dari aplikasi ?")
            setPositiveButton("Ya"){ _,_ ->
                exitProcess(0)
                super.onBackPressed()
            }
            setNegativeButton("Tidak"){_,_ ->

            }
        }.create().show()
    }



}