package com.checkgizi.tech.Model

import com.google.firebase.database.DataSnapshot

class DataAnak{
    var nama = ""
    var tgl = ""
    var jk = ""
    constructor(nama: String, tgl: String, jk: String){
        this.nama = nama
        this.tgl = tgl
        this.jk = jk
    }
}