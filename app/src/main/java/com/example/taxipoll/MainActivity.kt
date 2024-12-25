package com.example.taxipoll

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.taxipoll.fragments.KontaktFragment
import com.example.taxipoll.fragments.ObjaviteFragment
import com.example.taxipoll.fragments.ProfilFragment
import com.example.taxipoll.fragments.VoznjeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Navigacija za dugmad u navigacionoj traci
        findViewById<ImageButton>(R.id.btnPretrazite).setOnClickListener {
            startActivity(Intent(this@MainActivity, MainActivity::class.java))
        }

        findViewById<ImageButton>(R.id.btnObjavite).setOnClickListener {
            replaceFragment(ObjaviteFragment())
        }
        findViewById<ImageButton>(R.id.btnVoznje).setOnClickListener {
            replaceFragment(VoznjeFragment())
        }
        findViewById<ImageButton>(R.id.btnKontakt).setOnClickListener {
            replaceFragment(KontaktFragment())
        }
        findViewById<ImageButton>(R.id.btnProfil).setOnClickListener {
            replaceFragment(ProfilFragment())
        }

        // Navigacija za dugme MainPretraziBtn
        findViewById<Button>(R.id.MainPretraziBtn).setOnClickListener {
            replaceFragment(VoznjeFragment()) // Navigacija na VoznjeFragment
        }
    }

    private fun replaceFragment(fragment: Fragment?) {
        // Zameni fragment samo ako nije null
        fragment?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, it)
                .addToBackStack(null) // Omogućava povratak na prethodni fragment
                .commit()
        }

        // Podesi vidljivost CardView za polje pretrage
        val cardView = findViewById<CardView>(R.id.cardPretraga)
        cardView.visibility = if (fragment == null) View.VISIBLE else View.GONE
    }
}
