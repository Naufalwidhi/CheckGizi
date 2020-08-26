package com.checkgizi.tech.Activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import com.checkgizi.tech.Adapter.DataBahanMakananAdapter
import com.checkgizi.tech.Model.DataBahanMakanan
import com.checkgizi.tech.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_hitung_gizi.*

class HitungGiziActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    lateinit var dataList: MutableList<DataBahanMakanan>
    lateinit var RV: ListView

    var list0 = 0
    var list1 = 0
    var list2 = 0
    var list3 = 0
    var list4 = 0
    var list5 = 0
    var list6 = 0
    var list7 = 0
    var list8 = 0
    var list9 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung_gizi)

        val umur = intent.getStringExtra("umur")

        val umr = findViewById<TextView>(R.id.tv_kalori_anak)
        umr.apply {
            text = umur
        }

    }

    private fun load() {
        dataList = mutableListOf()
        database = FirebaseDatabase.getInstance().getReference("DataMakanan")
        RV = findViewById(R.id.rv_daftar_makanan)!!

        database.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()) {
                    for (h in p0.children) {
                        val data = h.getValue(DataBahanMakanan::class.java)
                        dataList.add(data!!)
                    }
                    val adapter = DataBahanMakananAdapter(
                        applicationContext,
                        R.layout.item_daftar_bahan_makanan,
                        dataList
                    )
                    RV.adapter = adapter
                    RV.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
                        if (position == 0) {
                            if (list0 == 0) {
                                list0 = 160
                            }
                            if (list1 == 0) {
                                list1 = 160
                            }
                            if (list2 == 0) {
                                list2 = 160
                            }
                            if (list3 == 0) {
                                list3 = 160
                            }
                            if (list4 == 0) {
                                list4 = 160
                            }
                            if (list5 == 0) {
                                list5 = 160
                            }
                            if (list6 == 0) {
                                list6 = 160
                            }
                            if (list7 == 0) {
                                list7 = 160
                            }
                            if (list8 == 0) {
                                list8 = 160
                            }
                            if (list9 == 0) {
                                list9 = 160
                            }
                        }
                        if (position == 1) {
                            if (list0 == 0) {
                                list0 = 52
                            }
                            if (list1 == 0) {
                                list1 = 52
                            }
                            if (list2 == 0) {
                                list2 = 52
                            }
                            if (list3 == 0) {
                                list3 = 52
                            }
                            if (list4 == 0) {
                                list4 = 52
                            }
                            if (list5 == 0) {
                                list5 = 52
                            }
                            if (list6 == 0) {
                                list6 = 52
                            }
                            if (list7 == 0) {
                                list7 = 52
                            }
                            if (list8 == 0) {
                                list8 = 52
                            }
                            if (list9 == 0) {
                                list9 = 52
                            }
                        }
                        if (position == 2) {
                            if (list0 == 0) {
                                list0 = 239
                            }
                            if (list1 == 0) {
                                list1 = 239
                            }
                            if (list2 == 0) {
                                list2 = 239
                            }
                            if (list3 == 0) {
                                list3 = 239
                            }
                            if (list4 == 0) {
                                list4 = 239
                            }
                            if (list5 == 0) {
                                list5 = 239
                            }
                            if (list6 == 0) {
                                list6 = 239
                            }
                            if (list7 == 0) {
                                list7 = 239
                            }
                            if (list8 == 0) {
                                list8 = 239
                            }
                            if (list9 == 0) {
                                list9 = 239
                            }
                        }
                        if (position == 3) {
                            if (list0 == 0) {
                                list0 = 20
                            }
                            if (list1 == 0) {
                                list1 = 20
                            }
                            if (list2 == 0) {
                                list2 = 20
                            }
                            if (list3 == 0) {
                                list3 = 20
                            }
                            if (list4 == 0) {
                                list4 = 20
                            }
                            if (list5 == 0) {
                                list5 = 20
                            }
                            if (list6 == 0) {
                                list6 = 20
                            }
                            if (list7 == 0) {
                                list7 = 20
                            }
                            if (list8 == 0) {
                                list8 = 20
                            }
                            if (list9 == 0) {
                                list9 = 20
                            }
                        }
                        if (position == 4) {
                            if (list0 == 0) {
                                list0 = 53
                            }
                            if (list1 == 0) {
                                list1 = 53
                            }
                            if (list2 == 0) {
                                list2 = 53
                            }
                            if (list3 == 0) {
                                list3 = 53
                            }
                            if (list4 == 0) {
                                list4 = 53
                            }
                            if (list5 == 0) {
                                list5 = 53
                            }
                            if (list6 == 0) {
                                list6 = 53
                            }
                            if (list7 == 0) {
                                list7 = 53
                            }
                            if (list8 == 0) {
                                list8 = 53
                            }
                            if (list9 == 0) {
                                list9 = 53
                            }
                        }
                        if (position == 5) {
                            if (list0 == 0) {
                                list0 = 107
                            }
                            if (list1 == 0) {
                                list1 = 107
                            }
                            if (list2 == 0) {
                                list2 = 107
                            }
                            if (list3 == 0) {
                                list3 = 107
                            }
                            if (list4 == 0) {
                                list4 = 107
                            }
                            if (list5 == 0) {
                                list5 = 107
                            }
                            if (list6 == 0) {
                                list6 = 107
                            }
                            if (list7 == 0) {
                                list7 = 107
                            }
                            if (list8 == 0) {
                                list8 = 107
                            }
                            if (list9 == 0) {
                                list9 = 107
                            }
                        }
                        if (position == 6) {
                            if (list0 == 0) {
                                list0 = 202
                            }
                            if (list1 == 0) {
                                list1 = 202
                            }
                            if (list2 == 0) {
                                list2 = 202
                            }
                            if (list3 == 0) {
                                list3 = 202
                            }
                            if (list4 == 0) {
                                list4 = 202
                            }
                            if (list5 == 0) {
                                list5 = 202
                            }
                            if (list6 == 0) {
                                list6 = 202
                            }
                            if (list7 == 0) {
                                list7 = 202
                            }
                            if (list8 == 0) {
                                list8 = 202
                            }
                            if (list9 == 0) {
                                list9 = 202
                            }
                        }
                        if (position == 7) {
                            if (list0 == 0) {
                                list0 = 94
                            }
                            if (list1 == 0) {
                                list1 = 94
                            }
                            if (list2 == 0) {
                                list2 = 94
                            }
                            if (list3 == 0) {
                                list3 = 94
                            }
                            if (list4 == 0) {
                                list4 = 94
                            }
                            if (list5 == 0) {
                                list5 = 94
                            }
                            if (list6 == 0) {
                                list6 = 94
                            }
                            if (list7 == 0) {
                                list7 = 94
                            }
                            if (list8 == 0) {
                                list8 = 94
                            }
                            if (list9 == 0) {
                                list9 = 94
                            }
                        }
                        if (position == 8) {
                            if (list0 == 0) {
                                list0 = 257
                            }
                            if (list1 == 0) {
                                list1 = 257
                            }
                            if (list2 == 0) {
                                list2 = 257
                            }
                            if (list3 == 0) {
                                list3 = 257
                            }
                            if (list4 == 0) {
                                list4 = 257
                            }
                            if (list5 == 0) {
                                list5 = 257
                            }
                            if (list6 == 0) {
                                list6 = 257
                            }
                            if (list7 == 0) {
                                list7 = 257
                            }
                            if (list8 == 0) {
                                list8 = 257
                            }
                            if (list9 == 0) {
                                list9 = 257
                            }
                        }
                        if (position == 9) {
                            if (list0 == 0) {
                                list0 = 239
                            }
                            if (list1 == 0) {
                                list1 = 239
                            }
                            if (list2 == 0) {
                                list2 = 239
                            }
                            if (list3 == 0) {
                                list3 = 239
                            }
                            if (list4 == 0) {
                                list4 = 239
                            }
                            if (list5 == 0) {
                                list5 = 239
                            }
                            if (list6 == 0) {
                                list6 = 239
                            }
                            if (list7 == 0) {
                                list7 = 239
                            }
                            if (list8 == 0) {
                                list8 = 239
                            }
                            if (list9 == 0) {
                                list9 = 239
                            }
                        }
                        if (position == 10) {
                            list0 = 160
                        }
                        if (position == 11) {
                            list0 = 160
                        }
                        if (position == 12) {
                            list0 = 160
                        }
                        if (position == 13) {
                            list0 = 160
                        }
                        if (position == 14) {
                            list0 = 160
                        }
                        if (position == 15) {
                            list0 = 160
                        }
                        if (position == 16) {
                            list0 = 160
                        }
                        if (position == 17) {
                            list0 = 160
                        }
                        if (position == 18) {
                            list0 = 160
                        }
                        if (position == 19) {
                            list0 = 160
                        }
                        if (position == 20) {
                            list0 = 160
                        }
                        if (position == 21) {
                            list0 = 160
                        }
                        if (position == 22) {
                            list0 = 160
                        }
                        if (position == 23) {
                            list0 = 160
                        }
                        if (position == 24) {
                            list0 = 160
                        }
                        if (position == 25) {
                            list0 = 160
                        }
                        if (position == 26) {
                            list0 = 160
                        }
                        if (position == 27) {
                            list0 = 160
                        }
                        if (position == 28) {
                            list0 = 160
                        }
                        if (position == 29) {
                            list0 = 160
                        }
                        if (position == 30) {
                            list0 = 160
                        }
                        if (position == 31) {
                            list0 = 160
                        }
                        if (position == 32) {
                            list0 = 160
                        }
                        if (position == 33) {
                            list0 = 160
                        }
                        if (position == 34) {
                            list0 = 160
                        }
                        if (position == 35) {
                            list0 = 160
                        }
                        if (position == 36) {
                            list0 = 160
                        }
                        if (position == 37) {
                            list0 = 160
                        }
                        if (position == 38) {
                            list0 = 160
                        }
                        if (position == 39) {
                            list0 = 160
                        }
                        if (position == 40) {
                            list0 = 160
                        }
                        if (position == 41) {
                            list0 = 160
                        }
                        if (position == 42) {
                            list0 = 160
                        }
                        if (position == 43) {
                            list0 = 160
                        }
                        if (position == 44) {
                            list0 = 160
                        }
                        if (position == 45) {
                            list0 = 160
                        }
                        if (position == 46) {
                            list0 = 160
                        }
                        if (position == 47) {
                            list0 = 160
                        }
                        if (position == 48) {
                            list0 = 160
                        }
                        if (position == 49) {
                            list0 = 160
                        }
                        if (position == 50) {
                            list0 = 160
                        }
                        if (position == 51) {
                            list0 = 160
                        }
                        if (position == 52) {
                            list0 = 160
                        }
                        if (position == 53) {
                            list0 = 160
                        }
                        if (position == 54) {
                            list0 = 160
                        }
                        if (position == 55) {
                            list0 = 160
                        }
                        if (position == 56) {
                            list0 = 160
                        }
                        if (position == 57) {
                            list0 = 160
                        }
                        if (position == 58) {
                            list0 = 160
                        }
                        if (position == 59) {
                            list0 = 160
                        }
                        if (position == 60) {
                            list0 = 160
                        }
                        if (position == 61) {
                            list0 = 160
                        }
                        if (position == 62) {
                            list0 = 160
                        }
                        if (position == 63) {
                            list0 = 160
                        }
                        if (position == 64) {
                            list0 = 160
                        }
                        if (position == 65) {
                            list0 = 160
                        }
                        if (position == 66) {
                            list0 = 160
                        }
                        if (position == 67) {
                            list0 = 160
                        }
                        if (position == 68) {
                            list0 = 160
                        }
                        if (position == 69) {
                            list0 = 160
                        }
                    }
                }
            }
        })
    }
}