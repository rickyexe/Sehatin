package com.ricky.sehatin

data class TipsMakanSehat(var id:Int, var title:String, var sumber:String, var link:String) {

    override fun toString(): String {
        return title
    }
}