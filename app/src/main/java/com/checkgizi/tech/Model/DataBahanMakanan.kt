package com.checkgizi.tech.Model

class DataBahanMakanan (val Nama: String, val Kalori: Double, val Karbohidrat: Double, val Lemak: Double, val Protein: Double){
    constructor(): this("",0.0,0.0,0.0,0.0)
}