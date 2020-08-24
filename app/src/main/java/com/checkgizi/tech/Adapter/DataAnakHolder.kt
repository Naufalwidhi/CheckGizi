package com.checkgizi.tech.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.checkgizi.tech.Model.rv_dataanak
import com.checkgizi.tech.R
import kotlinx.android.synthetic.main.item_daftar_anak.view.*
import java.lang.StringBuilder
import java.util.ArrayList

class DataAnakAdapter(private val DataAnak: List<rv_dataanak>) : RecyclerView.Adapter<DataAnakHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): DataAnakHolder {
        return DataAnakHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_daftar_anak, viewGroup, false))
    }

    override fun getItemCount(): Int = DataAnak.size

    override fun onBindViewHolder(holder: DataAnakHolder, position: Int) {
        holder.bind(DataAnak[position])
    }
}

class DataAnakHolder(Itemview: View) : RecyclerView.ViewHolder(Itemview) {
    fun bind(data: rv_dataanak) {

        itemView.tv_nama_show?.text = data.nama
        itemView.tv_umur_show?.text = data.tgl
        itemView.tv_jk_show?.text = data.jk

    }
}
//
//class DataAnakAdapter: RecyclerView.Adapter<DataAnakVH>() {
//
//    private val MyData = arrayListOf<rv_dataanak>()
//
//    fun updatedata(data: ArrayList<rv_dataanak>) {
//        MyData.clear()
//        MyData.addAll(data)
//        notifyDataSetChanged()
//    }
//
//    fun adddata(movie: rv_dataanak) {
//        MyData.add(movie)
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAnakVH {
//        val view = LayoutInflater
//            .from(parent.context)
//            .inflate(R.layout.item_daftar_anak, parent, false)
//
//        return DataAnakVH(view)
//    }
//
//    override fun getItemCount(): Int {
//        return MyData.size
//    }
//
//    override fun onBindViewHolder(holder: DataAnakVH, position: Int) {
//        holder.bind(MyData[position])
//    }
//}
//
class DataAnakVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(data: rv_dataanak) {

        itemView.tv_nama_show?.text = data.nama
        itemView.tv_umur_show?.text = data.tgl
        itemView.tv_jk_show?.text = data.jk

    }
}