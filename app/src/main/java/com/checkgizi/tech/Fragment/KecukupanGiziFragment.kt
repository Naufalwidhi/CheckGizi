package com.checkgizi.tech.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.checkgizi.tech.Adapter.DataAnakAdapter
import com.checkgizi.tech.Adapter.DataBahanMakananAdapter
import com.checkgizi.tech.Model.DataAnak
import com.checkgizi.tech.Model.DataBahanMakanan
import com.checkgizi.tech.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_daftar_anak.*

class KecukupanGiziFragment : Fragment() {

    private lateinit var database: DatabaseReference
    lateinit var dataList: MutableList<DataBahanMakanan>
    lateinit var RV: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kecukupan_gizi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        load()
    }

    private fun load(){
        dataList = mutableListOf()
        database = FirebaseDatabase.getInstance().getReference("DataMakanan")
        RV = getView()!!.findViewById(R.id.rv_daftar_makanan)!!

        database.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()) {
                    for (h in p0.children) {
                        val data = h.getValue(DataBahanMakanan::class.java)
                        dataList.add(data!!)
                    }
                    val adapter =
                        DataBahanMakananAdapter(requireContext(), R.layout.item_daftar_bahan_makanan, dataList)
                    RV.adapter = adapter
                }
            }
        })
    }
}