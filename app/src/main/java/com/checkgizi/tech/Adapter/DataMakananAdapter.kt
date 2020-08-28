package com.checkgizi.tech.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.checkgizi.tech.Model.DataBahanMakanan
import com.checkgizi.tech.R

class DataMakananAdapter(
    val mCtx: Context,
    val layoutResId: Int,
    val DataList: List<DataBahanMakanan>,
    val listener: DataListener
) : ArrayAdapter<DataBahanMakanan>(mCtx, layoutResId, DataList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutResId, null)
        val tvname2 = view.findViewById<TextView>(R.id.tv_nama_makanan)
        val tvkalori2 = view.findViewById<TextView>(R.id.tv_kalori)
        val tvkarbo2 = view.findViewById<TextView>(R.id.tv_karbo)
        val tvlemak2 = view.findViewById<TextView>(R.id.tv_lemak)
        val tvprotein2 = view.findViewById<TextView>(R.id.tv_Protein)

        val data = DataList[position]
        val kalori = data.Kalori.toString()
        val karbo = data.Karbohidrat.toString()
        val lemak = data.Lemak.toString()
        val protein = data.Protein.toString()

        view.rootView.setOnClickListener{
            listener.onClick(position, data)
        }

        tvname2.text = data.Nama
        tvkalori2.text = kalori
        tvkarbo2.text = karbo
        tvlemak2.text = lemak
        tvprotein2.text = protein

        return view
    }
}

interface DataListener {
    fun onClick(position: Int, data: DataBahanMakanan)
}