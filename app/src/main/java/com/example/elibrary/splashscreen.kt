@file:Suppress("DEPRECATION")

package com.example.elibrary

import android.app.ActivityOptions
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.transition.Explode
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import kotlin.system.exitProcess

class splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splashscreen)



        if (checkForInternet(this)) {
            Toast.makeText(this, "Checking connection", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
                finish()
            },2000)
        } else {
            Toast.makeText(this, "Checking connection", Toast.LENGTH_SHORT).show()
            AlertDialog.Builder(this)
                .setTitle("no connection")
                .setMessage("Please check you connection")
                .setPositiveButton("Exit", DialogInterface.OnClickListener { dialogInterface, i ->
                    exitProcess(0)
                })
                .show()
        }




    }
    private fun checkForInternet(context: Context): Boolean {

        // register activity with the connectivity manager service
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // if the android version is equal to M
        // or greater we need to use the
        // NetworkCapabilities to check what type of
        // network has the internet connection
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            // Returns a Network object corresponding to
            // the currently active default data network.
            val network = connectivityManager.activeNetwork ?: return false

            // Representation of the capabilities of an active network.
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                // Indicates this network uses a Wi-Fi transport,
                // or WiFi has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

                // Indicates this network uses a Cellular transport. or
                // Cellular has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                // else return false
                else -> false
            }
        } else {
            // if the android version is below M
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }

}