package com.checkgizi.tech.Fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.checkgizi.tech.Activity.MainActivity
import com.checkgizi.tech.Activity.TambahAnakActivity
import com.checkgizi.tech.Adapter.DataAnakAdapter
import com.checkgizi.tech.Model.rv_dataanak
import com.checkgizi.tech.R
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_tambah_anak.*
import kotlinx.android.synthetic.main.fragment_daftar_anak.*

class DaftarAnakFragment : Fragment() {

    private lateinit var database: DatabaseReference
    private lateinit var DataAnakAdapter: DataAnakAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daftar_anak, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadfirebase()
        fab1.setOnClickListener {
            val intent = Intent(context, TambahAnakActivity::class.java)
            startActivity(intent)

        }
    }

    fun loadfirebase() {
        database = FirebaseDatabase.getInstance().getReference("Data Anak")

        var getdata = object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(p0: DataSnapshot) {
                val sb = StringBuilder()
                val nama = String()
                for (i in p0.children) {
                    var nama1 = arrayOf(i.child("nama").getValue())
                    var tgl1 = arrayOf(i.child("tgl").getValue())
                    var jk1 = arrayOf(i.child("jk").getValue())

                    sb.append("$nama1", "$tgl1", "$jk1")
                    tv_nama_show.setText(sb)
                }
                tv_nama_show.setText("$nama1")
            }
        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)
    }
}