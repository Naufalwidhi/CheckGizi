package com.checkgizi.tech.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.checkgizi.tech.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        btn_reg.setOnClickListener {
            signup()
        }
        btn_masuk.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun signup() {
        if (et_email_reg.text.toString().isEmpty()) {
            et_email_reg.error = "Please Enter Email"
            et_email_reg.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(et_email_reg.text.toString()).matches()) {
            et_email_reg.error = "Please Enter A Valid Email"
            et_email_reg.requestFocus()
            return
        }
        if (et_pass_reg.text.toString().isEmpty()) {
            et_pass_reg.error = "Please Enter Password"
            et_pass_reg.requestFocus()
            return
        }
        auth.createUserWithEmailAndPassword(
            et_email_reg.text.toString(),
            et_pass_reg.text.toString()
        )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    FirebaseDatabase.getInstance().getReference().child("User")
                        .child(task.result!!.user!!.uid).child("Email")
                        .setValue(et_email_reg.text.toString())
                    Login()
                } else {
                    Log.w("Hello, ", "error")
                    Toast.makeText(
                        this, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }
            }
    }

    fun Login() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    fun updateUI(currentUser: FirebaseUser?) {

    }
}