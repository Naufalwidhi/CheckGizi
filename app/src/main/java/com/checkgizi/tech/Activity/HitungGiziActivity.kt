package com.checkgizi.tech.Activity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.checkgizi.tech.Adapter.DataListener
import com.checkgizi.tech.Adapter.DataMakananAdapter
import com.checkgizi.tech.Model.DataBahanMakanan
import com.checkgizi.tech.R
import com.google.firebase.database.*

class HitungGiziActivity : AppCompatActivity(), DataListener {

    private lateinit var database: DatabaseReference
    lateinit var dataList: MutableList<DataBahanMakanan>
    lateinit var RV: ListView

    var kalori = ""
    var hasil = 0.0
    var nama = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung_gizi)

        val umur = intent.getStringExtra("umur")
        val nama = intent.getStringExtra("nama")
        val umur2 = umur.toInt()

        val umr = findViewById<TextView>(R.id.tv_umur)
        umr.apply { text = umur }
        val nm = findViewById<TextView>(R.id.tv_nama_)
        nm.apply { text = nama }

        if (umur2 < 6) {
            kalori = "550"
        }
        if (umur2 > 5 && umur2 < 11) {
            kalori = "725"
        }
        if (umur2 > 10 && umur2 < 36) {
            kalori = "1125"
        }
        if (umur2 > 35 && umur2 < 108) {
            kalori = "1600"

        }
        if (umur2 > 107) {
            kalori = "1850"
        }
        val kal = findViewById<TextView>(R.id.tv_kalori_anak)
        kal.apply {
            text = kalori
        }

        load()
    }

    private fun load() {
        dataList = mutableListOf()
        database = FirebaseDatabase.getInstance().getReference("DataMakanan")
        RV = findViewById(R.id.lv_gizi)!!
        RV.choiceMode = ListView.CHOICE_MODE_MULTIPLE

        database.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()) {
                    for (h in p0.children) {
                        val data = h.getValue(DataBahanMakanan::class.java)
                        dataList.add(data!!)
                        setView()
                        RV.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
                        }
                    }
                }
            }
        })
    }

    fun setView() {
        val adapter = DataMakananAdapter(
            applicationContext,
            R.layout.item_daftar_bahan_makanan,
            dataList, this
        )
        RV.adapter = adapter
    }

    override fun onClick(position: Int, data: DataBahanMakanan) {

        nama += data.Nama
        hasil += data.Kalori

        val bahan = findViewById<TextView>(R.id.tv_bahan_terpilih)
        bahan.setText(nama)

        val hit = findViewById<TextView>(R.id.tv_kalori_saatini)
        hit.apply {
            text = hasil.toString()
        }
    }
}