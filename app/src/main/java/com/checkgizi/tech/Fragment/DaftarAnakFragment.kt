package com.checkgizi.tech.Fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.checkgizi.tech.Activity.TambahAnakActivity
import com.checkgizi.tech.Adapter.DataAnakAdapter
import com.checkgizi.tech.Model.DataAnak
import com.checkgizi.tech.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_daftar_anak.*

class DaftarAnakFragment : Fragment() {

    private lateinit var database: DatabaseReference
    private lateinit var DataAnakAdapter: DataAnakAdapter
    lateinit var dataList: MutableList<DataAnak>
    lateinit var RV: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daftar_anak, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataList = mutableListOf()
        database = FirebaseDatabase.getInstance().getReference("DataAnak")
        RV = getView()?.findViewById(R.id.rv_daftar_anak)!!

        database.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()){
                    for (h in p0.children){
                        val data = h.getValue(DataAnak::class.java)
                        dataList.add(data!!)
                    }
                    val adapter = DataAnakAdapter(requireContext(), R.layout.item_daftar_anak, dataList)
                    RV.adapter = adapter
                }
            }
        })

        fab1.setOnClickListener {
            val intent = Intent(context, TambahAnakActivity::class.java)
            startActivity(intent)

        }
    }

}