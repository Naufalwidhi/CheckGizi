package com.checkgizi.tech.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.checkgizi.tech.Activity.HitungGiziActivity
import com.checkgizi.tech.R
import kotlinx.android.synthetic.main.fragment_riwayat.*

class RiwayatFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_riwayat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_tambah_anak_gizi.setOnClickListener {
            save()
        }


    }

    private fun save() {
        val nama = et_nama_anak_gizi.text.toString().trim()
        val tgl = et_umur.text.toString().trim()
        val umur = tgl.toInt()
        val jk = et_jk.text.toString().trim()

        if (nama.isEmpty()) {
            et_nama_anak_gizi.error = "Masukkan Nama Anak"
            et_nama_anak_gizi.requestFocus()
            return
        }
        if (tgl.isEmpty()) {
            et_umur.error = "Masukkan Umur Anak"
            et_umur.requestFocus()
            return
        }
        if (umur > 108) {
            et_umur.error = "Umur tidak boleh lebih dari 108 Bulan (9 Tahun)"
            et_umur.requestFocus()
            return
        }
        if (umur < 0) {
            et_umur.error = "Masukkan Umur dengan benar"
            et_umur.requestFocus()
            return
        }

        if (jk.isEmpty()) {
            et_jk.error = "Masukkan Jenis Kelamin Anak"
            et_jk.requestFocus()
            return
        }

        val intent = Intent(context, HitungGiziActivity::class.java)
        intent.putExtra("nama", nama)
        intent.putExtra("umur", tgl)
        startActivity(intent)
    }

}