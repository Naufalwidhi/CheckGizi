package com.checkgizi.tech.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.checkgizi.tech.Model.DataAnak
import com.checkgizi.tech.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class TambahAnakActivity : AppCompatActivity() {

    lateinit var et_nama_anak: EditText
    lateinit var et_tgl_lahir: EditText
    lateinit var et_jenis_kelamin: EditText
    lateinit var btn_tambah_anak: Button
    lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_anak)

        ref = FirebaseDatabase.getInstance().getReference("DataAnak")

        et_nama_anak = findViewById(R.id.et_nama_anak)
        et_tgl_lahir = findViewById(R.id.et_tgl_lahir)
        et_jenis_kelamin = findViewById(R.id.et_jenis_kelamin)
        btn_tambah_anak = findViewById(R.id.btn_tambah_anak)

        btn_tambah_anak.setOnClickListener {
         tambahkan()
        }
    }

    private fun tambahkan(){
        val nama = et_nama_anak.text.toString().trim()
        val tgl = et_tgl_lahir.text.toString().trim()
        val umur = tgl.toInt()
        val jk = et_jenis_kelamin.text.toString().trim()

        if (nama.isEmpty()){
            et_nama_anak.error = "Masukkan Nama Anak"
            et_nama_anak.requestFocus()
            return
        }
        if (tgl.isEmpty()){
            et_tgl_lahir.error = "Masukkan Umur Anak"
            et_tgl_lahir.requestFocus()
            return
        }
        if (umur>108){
            et_tgl_lahir.error = "Umur tidak boleh lebih dari 108 Bulan (9 Tahun)"
            et_tgl_lahir.requestFocus()
            return
        }
        if (umur<0){
            et_tgl_lahir.error = "Masukkan Umur dengan benar"
            et_tgl_lahir.requestFocus()
            return
        }

        if (jk.isEmpty()){
            et_jenis_kelamin.error = "Masukkan Jenis Kelamin Anak"
            et_jenis_kelamin.requestFocus()
            return
        }
        val dataid = nama
        val Data = DataAnak(nama, tgl, jk)

        ref.child(dataid).setValue(Data)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Log.w("Hello, ", "error")
                    Toast.makeText(
                        this, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}