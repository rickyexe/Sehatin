package com.ricky.sehatin

data class TipsHidupSehat(var id:Int, var title:String, var sumber:String) {

    override fun toString(): String {
        return title
    }
}