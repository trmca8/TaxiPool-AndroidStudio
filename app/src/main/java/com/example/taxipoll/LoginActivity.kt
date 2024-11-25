package com.example.taxipoll

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var email: TextView
    lateinit var password: TextView
    lateinit var loginBtn: Button
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.LogEmailTXT)
        password = findViewById(R.id.LogLozinkaTXT)
        loginBtn = findViewById(R.id.ProfilBtn)
        auth = FirebaseAuth.getInstance()


        loginBtn.setOnClickListener {
            var email = email.text
            var password = password.text

            if (email == null) {
                Toast.makeText(this@LoginActivity, "Niste uneli email", Toast.LENGTH_SHORT).show()
            }
            if (password == null) {
                Toast.makeText(this@LoginActivity, "Niste uneli sifru", Toast.LENGTH_SHORT).show()
            }

            auth.signInWithEmailAndPassword(email.toString(), password.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")

                        finish()

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
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