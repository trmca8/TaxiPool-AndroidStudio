package com.example.taxipoll

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Navigacija
        findViewById<ImageButton>(R.id.btnPretrazite).setOnClickListener {
            recreate()
        }

        findViewById<ImageButton>(R.id.btnObjavite).setOnClickListener {
            replaceFragment(ObjaviFragment())
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
    }

    private fun replaceFragment(fragment: Fragment?) {
        // Zameni fragment samo ako nije null (ostali tabovi)
        fragment?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, it)
                .commit()
        }

        // Proveri da li je aktivan "Pretrazite" ili ostali tabovi
        val cardView = findViewById<CardView>(R.id.cardPretraga)
        if (fragment == null) {
            // Ako je fragment null, to znači da smo na MainActivity (Pretrazite)
            cardView.visibility = View.VISIBLE
        } else {
            // Sakrij CardView za sve ostale tabove (fragmente)
            cardView.visibility = View.GONE
        }
    }


}