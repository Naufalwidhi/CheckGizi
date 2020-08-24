package com.checkgizi.tech.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.checkgizi.tech.Fragment.*
import com.checkgizi.tech.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView = findViewById<BottomNavigationView>(R.id.nav_bar)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            val fragment: Fragment
            when (menuItem.itemId) {
                R.id.list -> {
                    fragment = DaftarAnakFragment()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl_menu,
                        fragment,
                        fragment.javaClass.simpleName
                    ).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.hitung -> {
                    fragment = HitungGiziFragment()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl_menu,
                        fragment,
                        fragment.javaClass.simpleName
                    ).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.gizi -> {
                    fragment = KecukupanGiziFragment()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl_menu,
                        fragment,
                        fragment.javaClass.simpleName
                    ).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.riwayat -> {
                    fragment = RiwayatFragment()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl_menu,
                        fragment,
                        fragment.javaClass.simpleName
                    ).commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

}