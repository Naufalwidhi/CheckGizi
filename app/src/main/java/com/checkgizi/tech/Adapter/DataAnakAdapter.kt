package com.checkgizi.tech.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.checkgizi.tech.Model.DataAnak
import com.checkgizi.tech.R

class DataAnakAdapter (val mCtx: Context, val layoutResId: Int, val DataList: List<DataAnak>)
    : ArrayAdapter<DataAnak>(mCtx, layoutResId, DataList)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutResId, null)
        val tvName = view.findViewById<TextView>(R.id.tv_nama_show)
        val tvUmur = view.findViewById<TextView>(R.id.tv_umur_show)
        val tvJk = view.findViewById<TextView>(R.id.tv_jk_show)

        val data = DataList[position]

        tvName.text = data.nama
        tvUmur.text = data.tgl
        tvJk.text = data.jk

        return view
    }
}