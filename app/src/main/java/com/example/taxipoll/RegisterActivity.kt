package com.example.taxipoll

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    lateinit var email: TextView
    lateinit var password: TextView
    lateinit var Ime: TextView
    lateinit var Broj: TextView
    lateinit var registerBtn: Button
    lateinit var loginBtn: Button
    lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        email = findViewById(R.id.LogEmailTXT)
        password = findViewById(R.id.LogLozinkaTXT)
        Ime = findViewById(R.id.RegImePrezimeTXT)
        Broj = findViewById(R.id.RegBrojTXT)
        registerBtn = findViewById(R.id.ProfilBtn)
        loginBtn = findViewById(R.id.RegLoginBtn)


        loginBtn.setOnClickListener{
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

        registerBtn.setOnClickListener {
            var email = email.text.toString()
            var password = password.text.toString()
            var Ime = Ime.text.toString()
            var Broj = Broj.text.toString()
            auth = FirebaseAuth.getInstance()

            if (email == null) {
                Toast.makeText(this@RegisterActivity, "Niste uneli email", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            if (password == null) {
                Toast.makeText(this@RegisterActivity, "Niste uneli sifru", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            if (Ime == null) {
                Toast.makeText(this@RegisterActivity, "Niste uneli ime", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            if (Broj == null) {
                Toast.makeText(this@RegisterActivity, "Niste uneli broj", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
                        val intent = Intent(applicationContext, LoginActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
        }
    }
}
