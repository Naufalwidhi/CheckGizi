package com.checkgizi.tech.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.checkgizi.tech.R
import kotlinx.android.synthetic.main.activity_tambah_anak.*
import kotlinx.android.synthetic.main.fragment_hitung_gizi.*

class HitungGiziFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hitung_gizi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_hitung_imt.setOnClickListener { 
            hitung()
        }

    }

    private fun hitung(){
        val berat = view?.findViewById<EditText>(R.id.et_bb)
        val berat2 = berat?.text.toString()
        val berat3 = berat2.toDouble()
        val tinggi = view?.findViewById<EditText>(R.id.et_tb)
        val tinggi2 = tinggi?.text.toString()
        val tinggi3 = tinggi2.toDouble()
        val tinggi4 = tinggi3/100
        val tinggi5 = tinggi4*tinggi4
        val hasil = berat3/tinggi5

        val imt = view?.findViewById<TextView>(R.id.tv_imt)
        imt?.setText("Indeks Masa Tubuh Anak Anda = "+hasil)
    }

}