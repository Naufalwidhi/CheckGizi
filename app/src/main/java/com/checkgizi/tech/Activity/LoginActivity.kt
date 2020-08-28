package com.checkgizi.tech.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.checkgizi.tech.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        if (auth.getCurrentUser() != null) {
            // User is signed in (getCurrentUser() will be null if not signed in)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
            finish();
        }
        btn_login.setOnClickListener {
            login()
        }
        btn_daftar.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun login() {
        if (et_email_login.text.toString().isEmpty()) {
            et_email_login.error = "Please Enter Email"
            et_email_login.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(et_email_login.text.toString()).matches()) {
            et_email_login.error = "Please Enter A Valid Email"
            et_email_login.requestFocus()
            return
        }
        if (et_pass_login.text.toString().isEmpty()) {
            et_pass_login.error = "Please Enter Password"
            et_pass_login.requestFocus()
            return
        }
        auth.signInWithEmailAndPassword(
            et_email_login.text.toString(),
            et_pass_login.text.toString()
        )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Log.w("Hello, ", "error")
                    Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

}