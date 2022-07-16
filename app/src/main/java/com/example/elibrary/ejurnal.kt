package com.example.elibrary

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.system.exitProcess

class ejurnal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejurnal)

        val bottomnavigation = findViewById<BottomNavigationView>(R.id.botnavigation)
        bottomnavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(0, 0);
                    finish()
                }

                R.id.ic_peminjaman -> {
                    startActivity(Intent(this, peminjaman::class.java))
                    overridePendingTransition(0,0)
                    finish()

                }

                R.id.ejurnal -> {
                    startActivity(Intent(this, ejurnal::class.java))
                    overridePendingTransition(0,0)
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

        val webviewjurnal = findViewById<WebView>(R.id.webviewejurnal)
        webviewjurnal.loadUrl("https://ikariegroup.co.id/ejurnal.php")
        webviewjurnal.webViewClient = WebViewClient()
        webviewjurnal.settings.domStorageEnabled = true
        webviewjurnal.settings.javaScriptEnabled = true






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