package com.example.elibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    //  uuuuu tralalalalla inisiasi variable

    private val homeFragment = com.example.elibrary.fragment.homeFragment()
    private  val bookFragment = com.example.elibrary.fragment.bookFragment()
    private val processFragment = com.example.elibrary.fragment.processFragment()
    private val accountFragment = com.example.elibrary.fragment.accountFragment()
    private val bottomnavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changefragment(homeFragment)

        // ini deprecated sen on nya, bikin force exit

        bottomnavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> changefragment(homeFragment)
                R.id.listbook -> changefragment(bookFragment)
                R.id.peminjaman -> changefragment(processFragment)
                R.id.account -> changefragment(accountFragment)
            }
            true
        }

        }

    // function untuk ngarahin default open
    private fun changefragment(fragment : Fragment){
        if(fragment!=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}